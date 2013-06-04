package com.jvwl.hibernate.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.junit.Test;

import com.jvwl.hibernate.beans.Group;
import com.jvwl.hibernate.beans.User;
import com.jvwl.hibernate.util.HibernateUtil;

public class ReadTest {
	@Test
	public void testRead() {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			User user =(User) session.load(User.class, "20100328092245281");
			System.out.println(user.getId());
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			System.out.println(user.getCreateTime());
			System.out.println(user.getGroup().getName());
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

}
