package com.jvwl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jvwl.dao.ObjectDao;
import com.jvwl.model.User;
import com.jvwl.service.LoginService;
@Component("loginService")
public class LoginServiceImpl extends BaseServiceImpl implements LoginService{
	private ObjectDao<User> userDao;

	@Resource(name="objectDao")
	public void setUserDao(ObjectDao<User> userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(String username, String password) {
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
