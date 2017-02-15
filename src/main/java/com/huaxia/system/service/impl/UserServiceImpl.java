package com.huaxia.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huaxia.base.bean.DataTablePageHandler;
import com.huaxia.base.bean.ReqData;
import com.huaxia.system.bean.Role;
import com.huaxia.system.bean.User;
import com.huaxia.system.mapper.UserMapper;
import com.huaxia.system.service.IUserService;

/**
 * @description 用户管理Service
 * @author : zhangy
 * @date : 2016年12月23日 下午3:52:20
 */
@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private UserMapper um;
	
	/**
	 * 统计用户个数
	 */
	@Override
	public Long findUserCount(ReqData reqData) {
		Long num = um.findUserCount(reqData);
		return num == null ? 0 : num;
	}
	
	/**
	 * 查询用户集合
	 */
	@Override
	public List<User> findUserListPage(ReqData reqData) {
		List<User> users = um.findUserListPage(reqData);
		return users == null  ? new ArrayList<User>() : users;
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
		List<User> roles = findUserListPage(reqData);
		Long records = findUserCount(reqData);
		
		DataTablePageHandler handler = new DataTablePageHandler();
		handler.setAaData(roles);
		handler.setiDisplayLength(rows);
		handler.setiDisplayStart(start);
		handler.setiTotalRecords(records);
		handler.setiTotalDisplayRecords(records);
		handler.setsEcho(sEcho);
		return handler;
		
	}
	
	@Override
	public User selectUserById(Long id) {
		// TODO Auto-generated method stub
		return um.selectUserById(id);
	}
	
	@Override
	public User selectUserVoById(Map<String,Object> map) {
		return um.selectUserVoById(map);
	}
	
	
	public List<Role> dealUserRoles(List<Role> roles,User user){
		for(Role role : roles){
			if(user.getRoles() != null && user.getRoles().size() > 0){
				for(Role obj : user.getRoles()){
					if(role.getId() == obj.getId()){
						role.setFlag(true);
					}
				}
			}
			
		}
		return roles;
	}

	@Override
	public User findUserRoles(Map<Object, Object> map) {
		return um.findUserRoles(map);
	}
	
	
	
	
	
	
	
	
	
	
	/*public PageHandler getPageInfo(ReqData reqData){
		Map<Object,Object> map = new HashMap<Object,Object>();
		
		Integer curpage = Integer.parseInt((String) reqData.get("page"));
		Integer rows = Integer.parseInt((String) reqData.get("rows"));
		map.put("start",rows*(curpage-1));
		map.put("end",rows);
		List<User> users = findUserList(map);
		Long records = findCountUser(map);
		int total = (int) (records%rows == 0 ? records/rows : records/rows+1);
		PageHandler handler = new PageHandler();
		handler.setPage(curpage);
		handler.setTotal(total);
		handler.setRecords(records);
		handler.setFormList(users);
		return handler;
		
	}*/





}
