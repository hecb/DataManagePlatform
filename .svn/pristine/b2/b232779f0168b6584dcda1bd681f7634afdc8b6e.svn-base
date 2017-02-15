package com.huaxia.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.huaxia.base.controller.BaseController;
import com.huaxia.system.bean.Permission;
import com.huaxia.system.service.IPermService;

/**
 * @description
 * @author : zhangy
 * @date : 2016年12月27日 上午10:49:42
 */
@Controller
@RequestMapping("/perm")
public class PermController extends BaseController{
	@Autowired
	public IPermService iPermService;
	
	
	/**
	 * 跳转资源页面
	 * @return
	 */
	@RequestMapping("/showPermView")
	public String showPermView(){
		return "system/permtree";
	}
	
	/**
	 * 跳转资源新增页面
	 * @param pid
	 * @return
	 */
	@RequestMapping("/addPermView")
	public ModelAndView addPermView(@RequestParam("pid") String pid){
		ModelAndView mv =this.getModelAndView();
//		List<String> modules = iPermService.queryPermModuleList();
		String seq = iPermService.queryPermSeq();
		Permission prem = new Permission(); 
		if(pid != null && !"".equals(pid)){
			prem.setPid(Long.parseLong(pid));
		}
		
		prem.setSeq(seq);
		mv.setViewName("system/addPerm");
		mv.addObject("prem",prem);
//		mv.addObject("modules",modules);
        return mv;
	}
	
	/**
	 * 展现tree
	 * @return
	 */
	@RequestMapping("/findPerm")
	@ResponseBody
	public Object findPerm(){
		return iPermService.getTreeNode(this.getReqData());
	}
	
	/**
	 * 添加资源
	 * @return
	 */
	@RequestMapping("/addPerm")
	@ResponseBody
	public Object addPerm(){
		Boolean bln = iPermService.addPerm(this.getReqData());
		if(bln){
			return renderSuccess();
		}
		return renderError("新增资源，操作失败！");
		
	}
	
	/**
	 * 删除资源
	 * @param id
	 * @return
	 */
	@PostMapping("/delPerm")
    @ResponseBody
    public Object delPerm(@RequestParam Long id) {
		boolean bln = iPermService.delPerm(id);
		if(bln){
			return renderSuccess();
		}
		return renderError("删除资源，操作失败！");
    }
	
	/**
	 * 修改资源资源
	 * @param id
	 * @return
	 */
	@PostMapping("/modifyPerm")
    @ResponseBody
    public Object modifyPerm() {
		boolean bln = iPermService.modifyPerm(this.getReqData());
		if(bln){
			return renderSuccess();
		}
		return renderError("修改资源，操作失败！");
    }
	
	
	/**
	 * 跳转资源修改页面
	 * @param pid
	 * @return
	 */
	@RequestMapping("/modifyPermView")
	public ModelAndView modifyPermView(@RequestParam("id") String id){
		ModelAndView mv =this.getModelAndView();
		Permission prem = iPermService.queryPermById(Long.parseLong(id));
		mv.setViewName("system/editPerm");
		mv.addObject("prem",prem);
        return mv;
	}

}
