package com.jvwl.daoimpl.hibernate;

import org.hibernate.Session;

import com.jvwl.dao.AdminMsgDao;
import com.jvwl.dao.PageDao;
import com.jvwl.model.Message;
import com.jvwl.util.HibernateUtil;

public class AdminMsgDaoImpl implements AdminMsgDao {

	public boolean deleteMsg(long id) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			Message message = (Message) session.get(Message.class, id);
			session.delete(message);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}

	public Message showMsg(long id) {
		Session session = null;
		Message message = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			message = (Message) session.get(Message.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return message;
	}

	public PageDao showMsgsByPage(int pageSize, int pageNum) {
		PageDaoImpl pageDaoImpl = new PageDaoImpl();
		pageDaoImpl.setEntityName("Message");
		pageDaoImpl.setPageSize(pageSize);
		pageDaoImpl.setPageNum(pageNum);
		return pageDaoImpl;
	}
}
