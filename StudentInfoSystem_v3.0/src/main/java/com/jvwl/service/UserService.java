package com.jvwl.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.jvwl.bean.Pagination;
import com.jvwl.model.User;

public interface UserService {


	public void addUser(User user, String username);

	//修改密码
	public void updateUser(User user, String username);

	public void deleteUser(List<Serializable> ids, String username);

	public User findUser(String id);

	public Pagination<User> findUsers(Map<String, Object> map, int pageNum,
			int pageSize);

}