package com.jvwl.ibatis.dao.impl;

import java.io.Reader;
import java.util.List;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.jvwl.ibatis.dao.UserDao;
import com.jvwl.ibatis.model.User;

public class UserDaoImpl implements UserDao {

	private static SqlMapClient sqlMapClient =null;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int id) {
		try {
			sqlMapClient.insert("deleteUser",id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User findUser(int id) {
		User user = null;
		try {
			user =(User) sqlMapClient.queryForObject("findUser", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> findeUsers(String condition) {
		List<User> users = null;
		try {
			users = sqlMapClient.queryForList("findUsers");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void insertUser(User user) {
		try {
			Integer id = (Integer) sqlMapClient.insert("insertUser",user);
			System.out.println(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(User user) {
		try {
			sqlMapClient.update("updateUser",user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
