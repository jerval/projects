package com.mybatis.app.util;

public class Page {

	private Integer startNo;
	private Integer pageSize;
	private Integer pageNo;

	public Page() {
	}

	public Page(Integer pageNo, Integer pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.startNo = (this.pageNo - 1) * this.pageSize;
	}

	public Integer getStartNo() {
		return startNo;
	}

	public void setStartNo(Integer startNo) {
		this.startNo = startNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Page [startNo=" + startNo + ", pageSize=" + pageSize
				+ ", pageNo=" + pageNo + "]";
	}

}
