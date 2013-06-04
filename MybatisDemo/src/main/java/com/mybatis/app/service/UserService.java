package com.mybatis.app.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.app.mapper.UserMapper;
import com.mybatis.app.model.User;
import com.mybatis.app.util.MybatisUtil;
import com.mybatis.app.util.Page;

public class UserService {

	public void add(User user) {
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.add(user);
			session.commit();// 这里一定要提交，不然数据进不去数据库中
		} finally {
			session.close();
		}
	}

	public void update(User user) {
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.update(user);
			session.commit();// 这里一定要提交，不然数据进不去数据库中
		} finally {
			session.close();
		}
	}

	public void delete(Integer id) {
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.delete(id);
			session.commit();// 这里一定要提交，不然数据进不去数据库中
		} finally {
			session.close();
		}
	}

	public User findById(Integer id) {
		User user = null;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			user = mapper.findById(id);
		} finally { 
			session.close();
		}
		return user;
	}

	public List<User> findByPage(Integer pageNo, Integer pageSize) {
		List<User> users = null;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			users = mapper.findByPage(new Page(pageNo, pageSize));
		} finally {
			session.close();
		}
		return users;
	}

}
