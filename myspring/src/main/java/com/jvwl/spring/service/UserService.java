package com.jvwl.spring.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jvwl.spring.dao.UserDao;
import com.jvwl.spring.model.User;
@Component("userService")
public class UserService {
	private UserDao userDao;

	public void addUser(User user){
		userDao.addUser(user);
	}
	
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
