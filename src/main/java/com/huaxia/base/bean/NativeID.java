package com.huaxia.base.bean;
/**
 * @description 统一定义使用数据库Native方法管理主键的entity基类. mysql 主键采用自增长
 * @author : zhangy
 * @date : 2016年12月7日 下午2:47:19
 */
public class NativeID implements Identifiable<Long> {
	protected Long id;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
