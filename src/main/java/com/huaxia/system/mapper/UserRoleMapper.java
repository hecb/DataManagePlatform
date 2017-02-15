package com.huaxia.system.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.huaxia.base.bean.ReqData;

/**
 * @description
 * @author : zhangy
 * @date : 2016年12月30日 上午10:09:53
 */
public interface UserRoleMapper {
	
	/**
	 * 新增一条记录
	 * @param data
	 * @return
	 */
	@Insert("INSERT INTO t_user_role(user_id,role_id) "
			+ "VALUES(#{userid},#{roleid})") 
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int addUserRole(ReqData data);
	
	
	/**
	 * 根据userid删除记录
	 * @param id
	 * @return
	 */
	@Delete("DELETE FROM t_user_role WHERE user_id = #{userid}")
	public int delUserRoleByUserId(Long userid);
}
