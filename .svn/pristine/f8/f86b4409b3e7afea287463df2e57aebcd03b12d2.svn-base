package com.huaxia.system.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.huaxia.base.bean.ReqData;
import com.huaxia.system.bean.Role;

/**
 * @description
 * @author : zhangy
 * @date : 2016年12月22日 下午1:07:45
 */
public interface RoleMapper {
	
	/**
	 * 查询角色集合
	 * @param map
	 * @return
	 */
	public List<Role> findRoleList(Map<Object,Object> map);
	/**
	 * 统计角色
	 * @param map
	 * @return
	 */
	public Long findRoleCount(ReqData reqData);
	
	/**
	 * 分页 查询角色集合
	 * @param map
	 * @return
	 */
	public List<Role> findRoleListPage(ReqData reqData);
	
	/**
	 * 根据ID查询角色
	 * @param id
	 * @return
	 */
	@Select(" select * from t_role where id=#{id}")
	@ResultMap("com.huaxia.system.mapper.RoleMapper.roleMap") 
    public Role findRoleById(Long id);
	
	/**
	 * 查询角色的所有权限
	 * @param map
	 * @return
	 */
	public Role findRolePerms(Map<Object,Object> map);
}
