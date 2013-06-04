package com.jvwl.dao;

import java.util.List;

public interface PageDao {

    public int getMaxElements();
    public int getMaxPages();
    public int getPageSize();
    public int getPageNum();
    public List getList();
    
}
