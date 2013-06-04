package com.jvwl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jvwl.dao.ObjectDao;
import com.jvwl.model.User;
import com.jvwl.service.LoginService;

public class LoginServiceImpl extends BaseServiceImpl implements LoginService{
	private ObjectDao<User> userDao;

	public void setUserDao(ObjectDao<User> userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(String username, String password) {System.out.println(username+password);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("username", username);
		map.put("password", password);
		List<User> users = userDao.findObjectsStrict(User.class, map, 1, 1).getList();
		User user = null;
		if(users.size()==1){
		user = users.get(0);
		}
		return user;
	}
}
