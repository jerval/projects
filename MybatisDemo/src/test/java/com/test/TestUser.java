package com.test;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mybatis.app.model.User;
import com.mybatis.app.service.UserService;

public class TestUser {

	private static UserService userService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userService = new UserService();
	}

	@Test
	public void testAdd() {
		userService.add(null);
		//userService.add(new User(null, "jerval", "12345", 23, null));
	}

	@Test
	public void testUpdate() {
		userService.update(new User(9, "jervalj", "888888", 23, new Date()));
	}

	@Test
	public void testDelete() {
		userService.delete(4);
	}

	@Test
	public void testFindById() {
		User user = userService.findById(6);
		System.out.println(user);
	}

	@Test
	public void testFindByPage() {
		List<User> users = userService.findByPage(1, 5);
		System.out.println(users);
		System.out.println(users.size());
	}

}
