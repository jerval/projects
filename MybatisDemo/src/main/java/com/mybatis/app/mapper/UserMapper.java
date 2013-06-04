package com.mybatis.app.mapper;

import java.util.List;

import com.mybatis.app.model.User;
import com.mybatis.app.util.Page;

public interface UserMapper {

	public abstract void add(User user);

	public abstract void update(User user);

	public abstract void delete(Integer id);

	public abstract User findById(Integer id);

	public abstract List<User> findByPage(Page page);

}
