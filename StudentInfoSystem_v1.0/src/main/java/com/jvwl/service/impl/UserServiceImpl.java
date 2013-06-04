package com.jvwl.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.jvwl.bean.Pagination;
import com.jvwl.dao.ObjectDao;
import com.jvwl.model.User;
import com.jvwl.service.UserService;

public class UserServiceImpl extends BaseServiceImpl implements UserService{
	private ObjectDao<User> userDao;

	public void setUserDao(ObjectDao<User> userDao) {
		this.userDao = userDao;
	}

	public void addUser(User user, String username) {
		userDao.existObject(User.class, user.getUsername());
		userDao.addObject(user);
		saveLog(username, "添加用户：" + user.getUsername());
	}

	//Main using for update user's password
	public void updateUser(User user, String username) {
		userDao.updateObject(user);
		saveLog(username, "修改用户：" + user.getUsername());
	}

	public void deleteUser(List<Serializable> ids, String username) {
		userDao.deleteObjects(User.class, ids);
		saveLog(username, "删除用户：" + ids);
	}

	public User findUser(String id) {
		return userDao.findObject(User.class, id);
	}

	public Pagination<User> findUsers(Map<String, Object> map,
			int pageNum, int pageSize) {
		return userDao.findObjectsStrict(User.class, map, pageNum,
				pageSize);
	}
}
