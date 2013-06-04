package com.jvwl.test;

import java.util.List;

import org.junit.Test;

import com.jvwl.ibatis.dao.UserDao;
import com.jvwl.ibatis.dao.impl.UserDaoImpl;
import com.jvwl.ibatis.model.User;

public class UserTest {
	@Test
	public void test1() {
		UserDao userDao = new UserDaoImpl();
		List<User> list = userDao.findeUsers("");
		for(User u:list){
			System.out.println(u);
		}
	}
	@Test
	public void test2() {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findUser(2);
			System.out.println(user);
	}
	@Test
	public void test3() {
		User user = new User();
		//user.setId(5032);
		user.setUsername("eee");
		user.setPassword("ooo");
		UserDao userDao = new UserDaoImpl();
		userDao.insertUser(user);
	}
	@Test
	public void test5() {
		User user = new User();
		user.setId(2);
		user.setUsername("rroo");
		user.setPassword("pppp");
		UserDao userDao = new UserDaoImpl();
		userDao.updateUser(user);
	}
	@Test
	public void test4() {
		UserDao userDao = new UserDaoImpl();
		userDao.deleteUser(5);
	}
}
