package com.test;

import org.hibernate.Session;
import org.junit.Test;

import com.jvwl.test.model.Department;
import com.jvwl.test.util.HibernateUtils;


public class HibernateTest {

	@Test public void test(){
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Department department = new Department();
		department.setDepart_id("10011");
		department.setDepart_name("2012");
		department.setDepart_info("dfasfd");
		session.persist(department);
		session.getTransaction().commit();
		
	}
}
