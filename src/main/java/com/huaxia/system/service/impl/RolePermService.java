package com.huaxia.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxia.base.bean.ReqData;
import com.huaxia.system.bean.RolePerm;
import com.huaxia.system.mapper.RolePermMapper;
import com.huaxia.system.service.IRolePermService;

/**
 * @description
 * @author : zhangy
 * @date : 2016年12月30日 下午2:42:40
 */
@Service
public class RolePermService implements IRolePermService {
	
	@Autowired
	private RolePermMapper rpm;
	
	@Override
	public int addRolePerm(RolePerm rp) {
		// TODO Auto-generated method stub
		return rpm.addRolePerm(rp);
	}

	@Override
	public int delRolePermByRoleId(Long roleid) {
		// TODO Auto-generated method stub
		return rpm.delRolePermByRoleId(roleid);
	}

	@Override
	public boolean delAndAddRolePerm(ReqData reqData) {
		// TODO Auto-generated method stub
		try {
			Long roleid = Long.parseLong(reqData.get("roleid").toString());
			delRolePermByRoleId(roleid);
			Object obj = reqData.get("permids");
			String[] permids= obj== null ? null : obj.toString().split(",");
			for(String permid : permids){
				if(permid == null || "".equals(permid)){
					continue;
				}
				RolePerm rp = new RolePerm();
				rp.setRoleId(roleid);
				rp.setPermId(Long.parseLong(permid));
				addRolePerm(rp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
