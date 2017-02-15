package com.huaxia.system.bean;

import java.io.Serializable;
import java.util.List;

import com.huaxia.base.bean.NativeID;

/**
 * @description 角色 bean
 * @author : zhangy
 * @date : 2016年12月22日 上午11:24:16
 */
public class Role extends NativeID implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String roleName;
	private List<Permission> perms;
	private boolean flag = false;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}


	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public List<Permission> getPerms() {
		return perms;
	}


	public void setPerms(List<Permission> perms) {
		this.perms = perms;
	}


	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}
