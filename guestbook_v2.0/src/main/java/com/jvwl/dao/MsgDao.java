
package com.jvwl.dao;

import com.jvwl.model.Message;

public interface MsgDao {
public boolean addMsg(Message msg);
public PageDao showMsgsByPage(int pageSize,int pageNumber);
}
