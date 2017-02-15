package com.huaxia.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaxia.system.bean.Permission;
import com.huaxia.system.bean.Role;
import com.huaxia.system.bean.User;
import com.huaxia.system.mapper.UserMapper;
import com.huaxia.system.service.ILoginService;

/**
 * @description 登录实现
 * @author : zhangy
 * @date : 2016年12月6日 下午4:56:42
 */

@Service
public class LoginServiceImpl implements ILoginService{
	
	@Resource
	private UserMapper um;


	@Override
    public User selectByUsername(String username) {
        return um.login(username);
    }


	@Override
	public User selectById(Long id) {
		return um.selectUserById(id);
	}


	@Override
	public User selectUserVoById(Map<String,Object> map) {
		return um.selectUserVoById(map);
	}
	
	public List<Permission> getMenu(Map<String,Object> map){
		User userPerm =this.selectUserVoById(map);
		List<Permission> perm1 = new ArrayList<Permission>(); 
		List<Permission> perm2 = new ArrayList<Permission>();

		if(userPerm != null){
			List<Role> listRole = userPerm.getRoles();
			if(listRole != null){
				for(Role role : listRole){
					List<Permission> listPerm = role.getPerms();
					for(Permission perm : listPerm){
						if(perm.getPid() == null){
							perm1.add(perm);
						}else{
							perm2.add(perm);
						}
					}
				}
			}
		}
//		Set<Permission> listSet1 = new HashSet<Permission>(perm1); 
//		Set<Permission> listSet2 = new HashSet<Permission>(perm2);
//		
//		
//		List<Permission> menu1 = new ArrayList<Permission>(listSet1); 
//		List<Permission> menu2 = new ArrayList<Permission>(listSet2);
		if(perm1 != null && perm1 != null){
			for(Permission p1 : perm1){
				 for(Permission p2 : perm2){
					 if(p1.getId().equals(p2.getPid())){
						 if(p1.getPermList() == null){
							 p1.setPermList(new ArrayList<Permission>()); 
						 }
						 p1.getPermList().add(p2);
					 }
				 }
				 
			}
		}
		
		return perm1;
	}

}
