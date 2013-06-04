package cn.itcast.bbs.init;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.bbs.domain.User;

public class InitTest {

	@Test
	public void testHibernate(){// hbm2ddl=update
		Configuration cfg = new Configuration().configure();
		cfg.buildSessionFactory();
	}
	
	@Test
	public void testSpring(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		SessionFactory sf = (SessionFactory) ac.getBean("sessionFactory");
		System.out.println(sf);
		
//		List list = sf.openSession().createQuery("FROM xxx").list();
		Object list = sf.openSession().get(User.class	, 1);
		System.out.println(list);
	}
	
	public void test(){
		Serializable[] arr = null;
		arr = new String[]{};
		arr = new Integer[]{};
	}
}
