package com.huaxia.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxia.base.bean.ReqData;
import com.huaxia.system.mapper.UserRoleMapper;
import com.huaxia.system.service.IUserRoleService;

/**
 * @description
 * @author : zhangy
 * @date : 2016年12月30日 上午10:13:25
 */

@Service
public class UserRoleServiceIpml implements IUserRoleService {
	@Autowired
	private UserRoleMapper urm;
	
	@Override
	public int addUserRole(ReqData data) {
		// TODO Auto-generated method stub
		return urm.addUserRole(data);
	}
	
	@Override
	public int delUserRoleByUserId(Long userid){
		return urm.delUserRoleByUserId(userid);
	}
	
	public boolean delAndAddUserRole(ReqData reqData){
		try {
			Long userid = Long.parseLong(reqData.get("userid").toString());
			delUserRoleByUserId(userid);
			
			addUserRole(reqData);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
