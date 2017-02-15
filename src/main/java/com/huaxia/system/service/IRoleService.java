package com.huaxia.system.service;
/**
 * @description 角色Service
 * @author : zhangy
 * @date : 2016年12月29日 上午10:15:02
 */
import java.util.List;
import java.util.Map;

import com.huaxia.base.bean.DataTablePageHandler;
import com.huaxia.base.bean.ReqData;
import com.huaxia.base.bean.TreeNode;
import com.huaxia.system.bean.Permission;
import com.huaxia.system.bean.Role;
public interface IRoleService {
	
	Long findRoleCount(ReqData reqData);
	
	List<Role> findRoleListPage(ReqData reqData);
	
	List<Role> findRoleList(Map<Object,Object> map);
	
	DataTablePageHandler getPageInfo(ReqData reqData);
	
	Role findRoleById(Long id);
	
	Role findRolePerms(Map<Object,Object> map);
	
	List<TreeNode> getNodes(ReqData reqData,List<Permission> permList);
}
