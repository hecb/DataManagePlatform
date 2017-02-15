package com.huaxia.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.huaxia.base.bean.ReqData;
import com.huaxia.system.bean.Permission;

/**
 * @description PermissionMapper
 * @author : zhangy
 * @date : 2016年12月22日 上午11:04:59
 */
public interface PermissionMapper{
	
	/**
	 * 查询资源列表
	 * @param perm
	 * @return
	 */
	public List<Permission> findPermList(Permission perm);
	
	/**
	 * 新增资源
	 * @param data
	 * @return
	 */
	@Insert("INSERT INTO t_permission(name,action,module, pid,seq,type) "
			+ "VALUES(#{name},#{action},#{module},#{pid},#{seq},#{type})") 
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int addPerm(ReqData data);
	
	/**
	 * 查询资源所属模块
	 * @return
	 */
	@Select("SELECT DISTINCT module FROM t_permission")
	public List<String> queryPermModuleList();
	
	/**
	 * 获取下一个排序值
	 * @return
	 */
	@Select("SELECT max(seq)+1 FROM t_permission")
	public String queryPermSeq();
	
	/**
	 * 根据ID删除一条资源
	 * @param id
	 * @return
	 */
	@Delete("DELETE FROM t_permission WHERE id = #{id}")
	public int delPermById(Long id);
	
	/**
	 * 修改资源资源
	 * @param id
	 * @return
	 */
	@Update("UPDATE t_permission SET name=#{name},action=#{action},pid=#{pid},type=#{type} WHERE id = #{id}")
	public int modifyPerm(ReqData reqdata);
	
	/**
	 * 根据ID查询一条记录
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM t_permission WHERE id =#{id}")
	public Permission queryPermById(Long id);
}
