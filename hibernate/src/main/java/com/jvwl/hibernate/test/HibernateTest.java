package com.jvwl.hibernate.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

import com.jvwl.hibernate.beans.Group;
import com.jvwl.hibernate.beans.User;
import com.jvwl.hibernate.util.HibernateUtil;

import junit.framework.TestCase;

public class HibernateTest extends TestCase {
	public boolean save() {
		boolean isSave = false;
		Session session = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
			Group group1 = new Group();
			group1.setId(sdf.format(new Date()));
			group1.setName("½ÜÍþÍøÂç");
			
			User user1=new User();
			user1.setId(sdf.format(new Date()));
			user1.setUsername("User1");
			user1.setPassword("55555");
			user1.setCreateTime(new Date());
			
			User user2=new User();
			user2.setId(sdf.format(new Date()));
			user2.setUsername("User2");
			user2.setPassword("55555");
			user2.setCreateTime(new Date());
			
			User user3=new User();
			user3.setId(sdf.format(new Date()));
			user3.setUsername("User3");
			user3.setPassword("55555");
			user3.setCreateTime(new Date());
			
			Group group2 = new Group();
			group2.setId(sdf.format(new Date()));
			group2.setName("½ÜÍþ¹«Ë¾");
			
			User user4=new User();
			user4.setId(sdf.format(new Date()));
			user4.setUsername("User4");
			user4.setPassword("55555");
			user4.setCreateTime(new Date());
			
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession(session);
		}
		
		
		return isSave;
	}
}
