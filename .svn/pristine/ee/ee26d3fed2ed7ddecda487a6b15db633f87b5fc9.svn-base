package com.huaxia.system.service;

import java.util.List;

import com.huaxia.base.bean.ReqData;
import com.huaxia.base.bean.TreeNode;
import com.huaxia.system.bean.Permission;

/**
 * @description
 * @author : zhangy
 * @date : 2016年12月27日 上午10:56:29
 */
public interface IPermService {
	List<Permission> findPermList(ReqData reqdata);
	
	List<TreeNode> getTreeNode(ReqData reqdata);
	
	Boolean addPerm(ReqData reqdata);
	
	List<String> queryPermModuleList();
	
	String queryPermSeq();
	
	Boolean delPerm(Long id);
	
	Boolean modifyPerm(ReqData reqdata);
	
	Permission queryPermById(Long id);
}
