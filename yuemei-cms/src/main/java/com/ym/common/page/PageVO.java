package com.ym.common.page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页信息的公共类
 */
@SuppressWarnings("rawtypes")
public class PageVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer pageIndex;
	private Integer pageSize;
	private String sortField;
	private String sortOrder;
	private long total;
	private List data;
	
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	
}
