package com.jvwl;

import org.hibernate.Session;

import com.jvwl.bean.UserLevel;
import com.jvwl.model.User;
import com.jvwl.util.HibernateUtils;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Session session = HibernateUtils.getSession();
		session.beginTransaction();
//		Department department = new Department();
//		department.setId(12);
//		department.setVersion(0);
//		department.setDepart_id("10");
//		department.setDepart_name("je");
//		department.setDepart_info("info");
		//session.persist(department);
		//session.saveOrUpdate(department);
		User user = new User();
		user.setLevel(UserLevel.超级管理员);
		user.setUsername("aaa");
	//	user.setPassword("1111");
		session.update(user);
		//session.persist(user);
		//session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
	}

}
