package com.jvwl.hibernate.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;

import com.jvwl.hibernate.beans.Group;
import com.jvwl.hibernate.beans.User;
import com.jvwl.hibernate.util.HibernateUtil;

public class SaveTest {
	@Test
	public void save() {
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
			Group group1 = new Group();
			group1.setName("½ÜÍþÍøÂç");
			
			User user1=new User();
			user1.setUsername("User1");
			user1.setPassword("55555");
			user1.setCreateTime(new Date());
			user1.setGroup(group1);
			session.save(user1);

			User user2=new User();
			user2.setUsername("User2");
			user2.setPassword("55555");
			user2.setCreateTime(new Date());
			user2.setGroup(group1);
			session.save(user2);

			User user3=new User();
			user3.setUsername("User3");
			user3.setPassword("55555");
			user3.setCreateTime(new Date());
			user3.setGroup(group1);
			session.save(user3);

			Group group2 = new Group();
			group2.setName("½ÜÍþ¹«Ë¾");
			
			User user4=new User();
			user4.setUsername("User4");
			user4.setPassword("55555");
			user4.setCreateTime(new Date());
			user4.setGroup(group2);
			session.save(user4);

			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession(session);
		}
	}
}
