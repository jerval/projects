package com.jvwl.bean;

import java.util.List;

public class Pagination<T> {

    private List<T> list;
    private long maxElements;
    private int pageNum;
    private int pageSize;

    public Pagination(List<T> list,int pageNum,int pageSize,long maxElements){
    	this.list = list;
    	this.pageNum = pageNum;
    	this.pageSize = pageSize;
    	this.maxElements = maxElements;
    }
    public long  getMaxPages() {
        return (maxElements!=0) && (maxElements % pageSize == 0) ? maxElements / pageSize : maxElements / pageSize + 1;
    }

    public List<T> getList() {
        return list;
    }

    public long getMaxElements() {
        return maxElements;
    }
    public int getPageNum(){
    	return pageNum;
    }
}
