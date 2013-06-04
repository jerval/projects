package com.jvwl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jvwl.dao.UserDao;
import com.jvwl.model.User;
import com.jvwl.service.UserService;

@Component("userService")
public class UserServicImpl implements UserService {
	private UserDao userDao;

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void addUser(User user){
		userDao.addUser(user);
	}
}
