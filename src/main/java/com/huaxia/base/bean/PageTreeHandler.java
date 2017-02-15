package com.huaxia.base.bean;

import java.util.List;

/**
 * @description
 * @author : zhangy
 * @date : 2016年12月26日 下午4:30:20
 */
public class PageTreeHandler {
	/* 当前页数 */  
    private int page;  
    /* 总页数 */  
    private int total;  
    /* 总计录数  */  
    private long records;  
      
    private List<?> formList;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public long getRecords() {
		return records;
	}

	public void setRecords(long records) {
		this.records = records;
	}

	public List<?> getFormList() {
		return formList;
	}

	public void setFormList(List<?> formList) {
		this.formList = formList;
	}
}
