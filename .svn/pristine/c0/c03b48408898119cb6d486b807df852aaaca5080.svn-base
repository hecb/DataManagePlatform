package com.huaxia.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxia.base.bean.DataTablePageHandler;
import com.huaxia.base.bean.ReqData;
import com.huaxia.base.bean.TreeNode;
import com.huaxia.system.bean.Permission;
import com.huaxia.system.bean.Role;
import com.huaxia.system.mapper.RoleMapper;
import com.huaxia.system.service.IRoleService;

/**
 * @description
 * @author : zhangy
 * @date : 2016年12月29日 上午10:15:22
 */
@Service
public class RoleServiceImpl implements IRoleService{
	
	@Autowired
	private RoleMapper rm;
	
	
	/**
	 * 查询角色集合
	 */
	@Override
	public List<Role> findRoleList(Map<Object,Object> map) {
		// TODO Auto-generated method stub
		List<Role> roles = rm.findRoleList(map);
		return roles == null  ? new ArrayList<Role>() : roles;
	}
	
	/**
	 * 统计角色
	 */
	@Override
	public Long findRoleCount(ReqData reqData) {
		// TODO Auto-generated method stub
		Long num = rm.findRoleCount(reqData);
		return num == null ? 0 : num;
	}

	/**
	 * 分页 查询角色集合
	 */
	@Override
	public List<Role> findRoleListPage(ReqData reqData) {
		// TODO Auto-generated method stub
		List<Role> roles = rm.findRoleListPage(reqData);
		return roles == null  ? new ArrayList<Role>() : roles;
	}
	
	/**
	 * 分页
	 */
	public DataTablePageHandler getPageInfo(ReqData reqData){
		
		Integer start = Integer.parseInt((String) reqData.get("iDisplayStart"));
		Integer rows = Integer.parseInt((String) reqData.get("iDisplayLength"));
		Integer sEcho = Integer.parseInt((String) reqData.get("sEcho"));
		
		reqData.put("start",start);
		reqData.put("end",rows);
		List<Role> roles = findRoleListPage(reqData);
		Long records = findRoleCount(reqData);
		
		DataTablePageHandler handler = new DataTablePageHandler();
		handler.setAaData(roles);
		handler.setiDisplayLength(rows);
		handler.setiDisplayStart(start);
		handler.setiTotalRecords(records);
		handler.setiTotalDisplayRecords(records);
		handler.setsEcho(sEcho);
		return handler;
		
	}
	
	/**
	 * 根据ID获取Role对象
	 */
    public Role findRoleById(Long id) {
		return rm.findRoleById(id);
	}

	@Override
	public Role findRolePerms(Map<Object, Object> map) {
		// TODO Auto-generated method stub
		return rm.findRolePerms(map);
	}
	
	@SuppressWarnings("unchecked")
	public List<TreeNode> getNodes(ReqData reqData,List<Permission> permList){
		Role role = findRolePerms(reqData);
		List<Permission> perms = role.getPerms();
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		if(permList!=null && !permList.isEmpty()){
			for(Permission obj : permList){
				TreeNode node = new TreeNode(); 
				if(perms!=null && !perms.isEmpty()){
					for(Permission obj1 : perms){
						node.setId(obj.getId().toString());
						node.setName(obj.getName());
						node.setpId(obj.getPid() == null ? null : obj.getPid().toString());
						node.setOpen(true);
						if(obj.getId().equals(obj1.getId())){
							System.out.println("--------------");
							node.setChecked(true);
						}
						node.setNocheck(false);
						
					}
				}
				treeNodes.add(node);
			}
		}
		
		
		return treeNodes;
	}
    
    
    

}
