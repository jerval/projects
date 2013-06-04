package com.jdbc.factory;

import java.util.Date;

public class MainTest {

	public static void main(String[] args) {
		UserService userService = new UserService();
//		userService.addUser(new User("username", "password", 23, new Date()));
//	
//		User user = userService.findUserById(3);
//		System.out.println(user);
//		user.setUsername("jerval");
//		userService.updateUser(user);
		
//		userService.deleteUser(userService.findUserById(1));
		
		System.out.println(userService.findUserAll(1, 3));
	}
}
