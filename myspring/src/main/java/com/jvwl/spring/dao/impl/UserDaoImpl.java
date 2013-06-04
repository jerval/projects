package com.jvwl.spring.dao.impl;

import org.springframework.stereotype.Component;

import com.jvwl.spring.dao.UserDao;
import com.jvwl.spring.model.User;
@Component("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public boolean addUser(User user) {
		System.out.println("UserDaoImpl.addUser()");
		return false;
	}

}
