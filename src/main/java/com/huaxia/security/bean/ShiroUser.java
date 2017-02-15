package com.huaxia.security.bean;

import java.io.Serializable;

/**
 * @description 
 * @author : zhangy
 * @date : 2016年12月6日 上午10:37:29
 */
public class ShiroUser implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String username;
    
	public ShiroUser(Long id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    
    

}
