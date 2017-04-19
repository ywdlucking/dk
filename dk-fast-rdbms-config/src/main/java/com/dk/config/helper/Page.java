package com.dk.config.helper;

import java.util.List;
import java.util.Map;

public class Page<T> {
	
	public static enum SortDirection {
        ASC,
        DESC
    }
	
	private int start; //起始纪录位置
	private int page; //当前页
	private int pageSize = 10;  //默认页面大小
	private long totalSize;		//总纪录数
	
	private Map<String,SortDirection> sortMap;   
	
	private List<T> result;

	public Page() {
		this(1);
	}

	public Page(int page) {
		this(page, 10);
	}

	public Page(int page, int pageSize) {
		this.pageSize = pageSize;
		this.page = page;
		this.start = (page - 1)*pageSize;
	}
	
	public Page(int page, int pageSize, Map<String,SortDirection> sortMap) {
		this.pageSize = pageSize;
		this.page = page;
		this.start = (page - 1)*pageSize;
		this.sortMap = sortMap;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public Map<String, SortDirection> getSortMap() {
		return sortMap;
	}

	public void setSortMap(Map<String, SortDirection> sortMap) {
		this.sortMap = sortMap;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
	
	public boolean isSort() {
		return sortMap == null? false : true;
	}
	
}