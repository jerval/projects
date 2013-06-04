package com.jvwl.daoimpl.hibernate;

import org.hibernate.Session;

import com.jvwl.dao.MsgDao;
import com.jvwl.dao.PageDao;
import com.jvwl.model.Message;
import com.jvwl.util.HibernateUtil;

public class MsgDaoImpl implements MsgDao {

	public boolean addMsg(Message msg) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(msg);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}

	public PageDao showMsgsByPage(int pageSize, int pageNum) {
		PageDaoImpl pageDaoImpl = new PageDaoImpl();
		pageDaoImpl.setEntityName("Message");
		pageDaoImpl.setPageSize(pageSize);
		pageDaoImpl.setPageNum(pageNum);
		return pageDaoImpl;
	}
}
