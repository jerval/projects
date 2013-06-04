package com.jvwl.dao;

import com.jvwl.model.Message;

public interface AdminMsgDao {
public boolean deleteMsg(long id);
public Message showMsg(long id);
public PageDao showMsgsByPage(int pageSize,int pageNumber);
}
