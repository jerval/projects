package com.jvwl.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jvwl.spring.model.User;
import com.jvwl.spring.service.UserService;

public class SpringTest {
	@Test
	public void testSpring() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		User user = new User();
		user.setUsername("jerva");
		user.setPassword("32332");
		userService.addUser(user);
	}
}
