package com.huaxia.security.shiro;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.huaxia.security.bean.ShiroUser;
import com.huaxia.system.bean.User;
import com.huaxia.system.service.ILoginService;

/**
 * @description 权限认证
 * @author : zhangy
 * @date : 2016年12月6日 上午10:34:52
 */
public class ShiroDbRealm  extends AuthorizingRealm{
    private static final Logger LOGGER = LogManager.getLogger(ShiroDbRealm.class);

    @Autowired
    private ILoginService loginService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        LOGGER.info("Shiro开始登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User un = loginService.selectByUsername(token.getUsername());
       
        // 账号不存在
	    if (un == null) {
	          return null;
	    }
	    ShiroUser shiroUser = new ShiroUser(un.getId(), un.getUsername());
	    // 认证缓存信息
        return new SimpleAuthenticationInfo(shiroUser, un.getPassword().toCharArray(), getName());

    }
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
