package cn.itcast.bbs.service.impl;

import java.util.Date;

import org.junit.Test;

import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.service.UserService;
import cn.itcast.bbs.test.base.TestBase;

public class UserServiceTest extends TestBase {

	UserService userService = (UserService) applicationContext.getBean("userService");

	@Test
	public void testSaveUser() {
		User user = new User();
		user.setLoginName("superman");
		user.setNickname("superman");
		user.setPassword("xxx");
		
		System.out.println(userService);
		userService.save(user);
	}
	
	@Test
	public void testUpdateUser() {
		User user = userService.getById("402881e425c3f7f50125c3f7f97d0001");
		user.setLoginName("superman" + new Date());
		
		System.out.println(userService);
		userService.update(user);
	}
}
