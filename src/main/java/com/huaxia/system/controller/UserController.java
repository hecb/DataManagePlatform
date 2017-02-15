package com.huaxia.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.huaxia.base.bean.DataTablePageHandler;
import com.huaxia.base.bean.ReqData;
import com.huaxia.base.controller.BaseController;
import com.huaxia.system.bean.Role;
import com.huaxia.system.bean.User;
import com.huaxia.system.service.IRoleService;
import com.huaxia.system.service.IUserRoleService;
import com.huaxia.system.service.IUserService;

/**
 * @description 用户管理
 * @author : zhangy
 * @date : 2016年12月23日 下午3:30:41
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IUserRoleService userRoleService;
	
	
	@RequestMapping("/showUserListView")
	public String showUserListView(){
		return "system/userlist";
	}
	
	@ResponseBody
	@RequestMapping("/userlist")
	public Object queryUserList(){
		ReqData reqData = this.getReqData();
		DataTablePageHandler pageInfo = userService.getPageInfo(reqData);
		return pageInfo;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/showUserRoleView")
	public ModelAndView showUserRoleView(){
		ModelAndView mv =this.getModelAndView();
		List<Role> roles = roleService.findRoleList(null);
		User user = userService.findUserRoles(this.getReqData());
		userService.dealUserRoles(roles, user);
		
		mv.setViewName("system/configUserRole");
		mv.addObject("roles",roles);
		mv.addObject("user",user);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/configUserRole")
	public Object configUserRole(){
		if(userRoleService.delAndAddUserRole(this.getReqData())){
			return renderSuccess();
		}
		return renderError("");
	}
	
	
	
	
	
/*	@ResponseBody
	@RequestMapping("/userlist")
	public Object queryUserList(
			@RequestParam(value = "page", defaultValue = "1") String page,
			@RequestParam(value = "rows", defaultValue = "10") String rows){
		ReqData reqData = this.getReqData();
		reqData.put("page", page);
		reqData.put("rows", rows);
		PageHandler pageInfo = userService.getPageInfo(reqData);
		return pageInfo;
	}*/
	
}
