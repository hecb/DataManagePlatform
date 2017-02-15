package com.huaxia.system.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.huaxia.base.bean.ReqData;
import com.huaxia.system.bean.User;

/**
 * @description UserMapper
 * @author : zhangy
 * @date : 2016年12月6日 下午4:56:42
 */
public interface UserMapper {
	
	
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@Select("select * from t_user where username=#{un}")
	@ResultMap("com.huaxia.system.mapper.UserMapper.userMap") 
	public User login(@Param("un")String loginName);
	
	/**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
	
	@Select(" select * from t_user where id=#{id}")
	@ResultMap("com.huaxia.system.mapper.UserMapper.userMap") 
    public User selectUserById(Long id);
	
	/**
	 * 查询用户权限
	 * @param id
	 * @return
	 */
	public User selectUserVoById(Map<String,Object> map);
	
	/**
	 * 统计用户个数
	 * @return
	 */
	public Long findUserCount(ReqData reqData);
	
	/**
	 * 查询用户集合
	 * @param id
	 * @return
	 */
	public List<User> findUserListPage(ReqData reqData);
	
	/**
	 * 查询用户所拥有的角色
	 * @param map
	 * @return
	 */
	public User findUserRoles(Map<Object,Object> map);

}
