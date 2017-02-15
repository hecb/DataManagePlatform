package com.huaxia.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxia.base.bean.ReqData;
import com.huaxia.base.bean.TreeNode;
import com.huaxia.system.bean.Permission;
import com.huaxia.system.mapper.PermissionMapper;
import com.huaxia.system.service.IPermService;

/**
 * @description 权限操作SERVICE
 * @author : zhangy
 * @date : 2016年12月27日 上午10:58:34
 */
@Service
public class PermServiceImpl implements IPermService{
	@Autowired
	private PermissionMapper pm;
	
	/**
	 * 查找资源集合
	 */
	@Override
	public List<Permission> findPermList(ReqData reqdata) {
		// TODO Auto-generated method stub
		List<Permission> listPerm = pm.findPermList(null);
		return listPerm;
	}
	/**
	 * 封装成list Tree
	 */
	public List<TreeNode> getTreeNode(ReqData reqdata){
		List<Permission> listPerm = this.findPermList(reqdata);
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		for(Permission perm : listPerm){
			TreeNode node = new TreeNode(); 
			node.setId(perm.getId().toString());
			node.setName(perm.getName());
			node.setpId(perm.getPid() == null ? null : perm.getPid().toString());
			node.setOpen(true);
			node.setChecked(false);
			node.setNocheck(true);
			treeNodes.add(node);
		}
		return treeNodes;
	}

	/**
	 * 添加资源
	 */
	@Override
	public Boolean addPerm(ReqData reqdata){
		boolean bln = false;
		try {
			Object obj = reqdata.get("pid");
			if(obj == null || "".equals(obj)){
				reqdata.put("pid",null);
			}
			int i = pm.addPerm(reqdata);
			if(i == 1){
				bln = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bln;
	}

	/**
	 * 获取资源所属模块
	 */
	@Override
	public List<String> queryPermModuleList() {
		// TODO Auto-generated method stub
		return pm.queryPermModuleList();
	}
	
	/**
	 * 获取最新排序序列
	 */
	@Override
	public String queryPermSeq(){
		return pm.queryPermSeq();
	}

	/**
	 * 根据ID删除资源
	 */
	@Override
	public Boolean delPerm(Long id) {
		boolean bln = false;
		try {
			int i = pm.delPermById(id);
			if(i == 1 ){
				bln = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bln;
	}
	
	
	/**
	 * 修改资源
	 */
	@Override
	public Boolean modifyPerm(ReqData reqdata) {
		boolean bln = false;
		
		try {
			int i = pm.modifyPerm(reqdata);
			if(i == 1 ){
				bln = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bln;
	}
	
	@Override
	public Permission queryPermById(Long id) {
		return pm.queryPermById(id);
	}
	

	
	
	
}
