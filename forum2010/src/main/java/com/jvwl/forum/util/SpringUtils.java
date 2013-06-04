package com.jvwl.forum.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
	private static ApplicationContext context;
	static {
		try {
			context = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}
}
