package com.huaxia.base.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.huaxia.base.bean.ReqData;
import com.huaxia.base.bean.Result;
import com.huaxia.security.bean.ShiroUser;
import com.huaxia.system.bean.User;
import com.huaxia.system.service.ILoginService;

/**
 * @description 基础 controller
 * @author : zhangy
 * @date : 2016年12月6日 上午10:14:18
 */
public class BaseController {
	 protected Logger logger = LogManager.getLogger(getClass());

	 	@Autowired
	    private ILoginService loginService;

	    @InitBinder
	    public void initBinder(ServletRequestDataBinder binder) {
	        /**
	         * 自动转换日期类型的字段格式
	         */
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	    }

	    /**
	     * 获取当前登录用户对象
	     * @return
	     */
	    public User getCurrentUser() {
	        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
	        User currentUser = loginService.selectById(user.getId());
	        return currentUser;
	    }
	    
		/**
		 * 得到页面传过来的Data
		 */
		public ReqData getReqData(){
			return new ReqData(this.getRequest());
		}
		
	    
		/**
		 * 得到ModelAndView
		 */
		public ModelAndView getModelAndView(){
			return new ModelAndView();
		}
		
		/**
		 * 得到request对象
		 */
		public HttpServletRequest getRequest() {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			
			return request;
		}
		
		
		 /**
	     * ajax失败
	     * @param msg 失败的消息
	     * @return {Object}
	     */
	    public Object renderError(String msg) {
	        Result result = new Result();
	        result.setMsg(msg);
	        return result;
	    }

	    /**
	     * ajax成功
	     * @return {Object}
	     */
	    public Object renderSuccess() {
	        Result result = new Result();
	        result.setSuccess(true);
	        return result;
	    }

	    /**
	     * ajax成功
	     * @param msg 消息
	     * @return {Object}
	     */
	    public Object renderSuccess(String msg) {
	        Result result = new Result();
	        result.setSuccess(true);
	        result.setMsg(msg);
	        return result;
	    }

	    /**
	     * ajax成功
	     * @param obj 成功时的对象
	     * @return {Object}
	     */
	    public Object renderSuccess(Object obj) {
	        Result result = new Result();
	        result.setSuccess(true);
	        result.setObj(obj);
	        return result;
	    }

	   
	   
}
