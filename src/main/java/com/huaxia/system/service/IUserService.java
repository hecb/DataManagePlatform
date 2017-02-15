package com.huaxia.system.service;

import java.util.List;
import java.util.Map;

import com.huaxia.base.bean.DataTablePageHandler;
import com.huaxia.base.bean.ReqData;
import com.huaxia.system.bean.Role;
import com.huaxia.system.bean.User;

/**
 * @description 用户查询Service接口
 * @author : zhangy
 * @date : 2016年12月23日 下午3:49:38
 */
public interface IUserService {
	
	Long findUserCount(ReqData reqData);
	
	List<User> findUserListPage(ReqData reqData);
	
	DataTablePageHandler getPageInfo(ReqData reqData);
	
	User selectUserById(Long id);
	
	User selectUserVoById(Map<String,Object> map);
	
	List<Role> dealUserRoles(List<Role> roles,User user);
	
	User findUserRoles(Map<Object,Object> map);
	
	
}
