package com.huaxia.system.service;

import java.util.List;
import java.util.Map;

import com.huaxia.system.bean.Permission;
import com.huaxia.system.bean.User;

/**
 * @description 登录接口
 * @author : zhangy
 * @date : 2016年12月6日 下午4:56:42
 */
public interface ILoginService {
	User selectByUsername(String username);
	
	User selectById(Long id);
	
	User selectUserVoById(Map<String,Object> map);
	
	List<Permission> getMenu(Map<String,Object> map);
	
}
