package com.jvwl.forum.common;

import java.util.List;

/**
 *传输分页信息对象
 * 
 * @author 蹇伟
 */
public class Pagination<T> {

	private List<T> list;
	private long maxElements;
	private int pageNo;
	private int pageSize;

	public Pagination(List<T> list, long maxElements, int pageNo, int pageSize) {
		this.list = list;
		this.maxElements = maxElements;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public int getMaxPages() {
		return (maxElements != 0) && (maxElements % pageSize == 0) ? (int)(maxElements
				/ pageSize): (int)(maxElements / pageSize + 1);
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public long getMaxElements() {
		return maxElements;
	}

	public void setMaxElements(long maxElements) {
		this.maxElements = maxElements;
	}

	public int getPageNo() {
		if (pageNo < 1) {
			return 1;
		}
		if (pageNo > maxElements) {
			return (int)maxElements;
		}
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

	public int getNextPage() {
		int maxPages = getMaxPages();
		return pageNo < maxPages ? pageNo + 1 : maxPages;
	}

	public int getPreviousPage() {
		return pageNo > 1 ? pageNo - 1 : 1;
	}

	public boolean getHasNextPage() {
		return pageNo < getMaxPages();
	}

	public boolean getHasPreviousPage() {
		return pageNo > 1;
	}
	public boolean getListIsNull(){
		if(list!=null && list.size()>0){
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Pagination [listSize=" + (list!=null?list.size():0) + ", maxElements=" + maxElements
				+ ", pageNo=" + pageNo + ", pageSize=" + pageSize + "]";
	}
}
