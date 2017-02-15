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
import com.huaxia.system.bean.Permission;
import com.huaxia.system.bean.Role;
import com.huaxia.system.service.IPermService;
import com.huaxia.system.service.IRolePermService;
import com.huaxia.system.service.IRoleService;

/**
 * @description
 * @author : zhangy
 * @date : 2016年12月29日 上午10:14:12
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPermService permService;
	
	@Autowired
	private IRolePermService rolePermService;
	
	/**
	 * 展现角色列表
	 * @return
	 */
	@RequestMapping("/showRoleListView")
	public String showRoleListView(){
		return "system/rolelist";
	}
	
	/**
	 * 分页
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/rolelist")
	public Object queryRoleList(){
		ReqData reqData = this.getReqData();
		 
		DataTablePageHandler pageInfo = roleService.getPageInfo(reqData);
		return pageInfo;
	}
	
	
	
	@RequestMapping("/showRolePermView")
	public ModelAndView showUserRoleView(long id){
		ModelAndView mv =this.getModelAndView();
		Role role = roleService.findRoleById(id);
		mv.setViewName("system/configRolePerm");
		mv.addObject("role",role);
		return mv;
	}
	
	/**
	 * 展现tree
	 * @return
	 */
	@RequestMapping("/findRolePerms")
	@ResponseBody
	public Object findRolePerms(){
		List<Permission> permList = permService.findPermList(null);
		
		return roleService.getNodes(this.getReqData(), permList);
	}
	
	
	@ResponseBody
	@RequestMapping("/configRolePerm")
	public Object configRolePerm(){
		if(rolePermService.delAndAddRolePerm(this.getReqData())){
			return renderSuccess();
		}
		return renderError("");
	}
}
