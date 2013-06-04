package com.jvwl.dispatch;

import com.jvwl.dao.PageDao;
import com.jvwl.daoimpl.hibernate.AdminDaoImpl;
import com.jvwl.daoimpl.hibernate.AdminMsgDaoImpl;
import com.jvwl.daoimpl.hibernate.MsgDaoImpl;
import com.jvwl.model.Admin;
import com.jvwl.model.Message;

public class Dispatcher {
	 public static boolean adminLogin(Admin admin) {
	        return new AdminDaoImpl().login(admin);
	    }

	    public static boolean adminUpdatePwd(Admin admin) {
	        return new AdminDaoImpl().updatePassword(admin);
	    }

	    public static boolean adminDeleteMsg(long id) {
	        return new AdminMsgDaoImpl().deleteMsg(id);
	    }

	    public static Message adminShowMsg(long id) {
	        return new AdminMsgDaoImpl().showMsg(id);
	    }

	    public static PageDao adminShowMsgs(int pageSize,int pageNum) {
	        return new AdminMsgDaoImpl().showMsgsByPage(pageSize, pageNum);
	    }

	    public static boolean addMsg(Message msg) {
	        return new MsgDaoImpl().addMsg(msg);
	    }

	    public static PageDao showMsgs(int pageSize,int pageNum) {
	        return new MsgDaoImpl().showMsgsByPage(pageSize, pageNum);
	    }
}
