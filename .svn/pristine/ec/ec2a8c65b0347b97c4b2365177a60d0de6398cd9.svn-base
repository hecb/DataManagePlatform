package com.huaxia.system.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.huaxia.system.bean.RolePerm;

/**
 * @description
 * @author : zhangy
 * @date : 2016年12月30日 下午2:38:32
 */
public interface RolePermMapper {
	/**
	 * 新增一条记录
	 * @param data
	 * @return
	 */
	@Insert("INSERT INTO t_role_permission (role_id,perm_id) "
			+ "VALUES(#{roleId},#{permId})") 
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int addRolePerm(RolePerm rp);
	
	
	/**
	 * 根据roleid删除记录
	 * @param id
	 * @return
	 */
	@Delete("DELETE FROM t_role_permission WHERE role_id = #{roleid}")
	public int delRolePermByRoleId(Long roleid);
}
