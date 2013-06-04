package com.jvwl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jvwl.model.User;
import com.jvwl.service.UserService;

public class UserServiceTest {
	//@Test
	public void testUser(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService  userService = (UserService)ctx.getBean("userService");
		User user = new User();
		user.setUsername("juu");
		user.setPassword("11");
		userService.addUser(user);
	}

}
