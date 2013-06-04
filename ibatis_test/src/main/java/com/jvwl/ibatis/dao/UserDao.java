package com.jvwl.ibatis.dao;

import java.util.List;

import com.jvwl.ibatis.model.User;

public interface UserDao {
	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id);

	public User findUser(int id);

	public List<User> findeUsers(String condition);
}
