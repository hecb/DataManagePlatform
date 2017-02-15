package com.huaxia.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.huaxia.base.controller.BaseController;
import com.huaxia.system.bean.Permission;
import com.huaxia.system.bean.User;
import com.huaxia.system.service.ILoginService;

/**
 * @description 登陆
 * @author : zhangy
 * @date : 2016年12月6日 上午10:37:29
 */
@Controller
public class LoginController extends BaseController {
	
	@Autowired
	private ILoginService loginService;
    /**
     * 首页
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "redirect:/index";
    }

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(Model model) {
    	ModelAndView mv =this.getModelAndView();
    	User currentUser = getCurrentUser();
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", currentUser.getId());
		map.put("type", "menu");
		List<Permission> perms =loginService.getMenu(map);
		mv.setViewName("index");
		mv.addObject("menus",perms);
        return mv;
    }

    /**
     * GET 登录
     * @return {String}
     */
    @GetMapping("/login")
    public String login() {
        logger.info("GET请求登录");
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
        return "login";
    }

    /**
     * POST 登录 shiro 写法
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public Object loginPost(String username, String password) {
        logger.info("POST请求登录");

        if (StringUtils.isBlank(username)) {
            return renderError("用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            return renderError("密码不能为空");
        }
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            user.login(token);
            return renderSuccess();
        } catch (UnknownAccountException e) {
            throw new RuntimeException("账号不存在！", e);
        } catch (DisabledAccountException e) {
            throw new RuntimeException("账号未启用！", e);
        } catch (IncorrectCredentialsException e) {
            throw new RuntimeException("密码错误！", e);
        } catch (Throwable e) {
            throw new RuntimeException("未知错误,请联系管理员！", e);
        }
    }
    
    /**
     * 未授权
     * @return {String}
     */
    @GetMapping("/unauth")
    public String unauth() {
        if (SecurityUtils.getSubject().isAuthenticated() == false) {
            return "redirect:/login";
        }
        return "unauth";
    }

    /**
     * 退出
     * @return {Result}
     */
    @PostMapping("/logout")
    @ResponseBody
    public Object logout() {
        logger.info("退出");
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
        	subject.logout();
        }
        return renderSuccess();
    }
    
    /**
     * 跳转后台默认页面
     * @param model
     * @return
     */
    @RequestMapping("/defaultjsp") 
    public String defaultjsp() {
        return "system/default";
    }



}
