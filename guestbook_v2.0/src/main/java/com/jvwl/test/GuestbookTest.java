package com.jvwl.test;

import org.hibernate.Session;
import org.junit.Test;

import com.jvwl.dispatch.Dispatcher;
import com.jvwl.model.Admin;
import com.jvwl.util.HibernateUtil;


public class GuestbookTest {
	@Test
	public void add() {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			Admin admin = new Admin();
			admin.setUsername("jerval");
			admin.setPassword("121");
			System.out.println(Dispatcher.adminLogin(admin));
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
