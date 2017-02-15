package com.huaxia.base.bean;

import java.io.Serializable;

/**
 * @description
 * @author : zhangy
 * @date : 2016年12月27日 上午11:04:27
 */
public class TreeNode implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String pId;
	private String name;
	private boolean open;  //是否默认打开
	private boolean nocheck; //是否可以选
	private boolean checked; //是否默认选上
	
	
	
	public TreeNode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public TreeNode(String id, String pId, String name, boolean open, boolean nocheck, boolean checked) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.nocheck = nocheck;
		this.checked = checked;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isNocheck() {
		return nocheck;
	}
	public void setNocheck(boolean nocheck) {
		this.nocheck = nocheck;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
}
