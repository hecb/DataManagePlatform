package com.huaxia.system.service;

import com.huaxia.base.bean.ReqData;

/**
 * @description
 * @author : zhangy
 * @date : 2016年12月30日 上午10:11:50
 */
public interface IUserRoleService {
	
	int addUserRole(ReqData data);
	
	int delUserRoleByUserId(Long userid);
	
	boolean delAndAddUserRole(ReqData reqData);
}
