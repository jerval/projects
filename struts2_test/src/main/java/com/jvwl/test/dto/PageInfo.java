package com.jvwl.test.dto;


/**
 *传输分页信息对象
 * 
 * @author 蹇伟
 */
public class PageInfo {
	private int pageNo;
	private int pageSize;

	public PageInfo(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "PageInfo [pageNo=" + pageNo + ", pageSize=" + pageSize + "]";
	}

}
