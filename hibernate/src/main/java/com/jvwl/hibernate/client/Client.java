package com.jvwl.hibernate.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import javassist.expr.NewArray;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jvwl.hibernate.beans.User;
import com.jvwl.hibernate.util.HibernateUtil;

public class Client {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Session session =null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
			User user=new User();
			user.setId(sdf.format(new Date()));
			user.setUsername("≤‚ ‘");
			user.setPassword("55555");
			user.setCreateTime(new Date());
			
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.closeSession(session);
		}
	}
}
