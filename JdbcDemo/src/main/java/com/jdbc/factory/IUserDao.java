package com.jdbc.factory;

import java.util.List;

import com.jdbc.domain.User;

/**
 * 
 * @author Jerval
 *
 * @date 2011-6-1
 */
public interface IUserDao {

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public User findUserById(Integer id);

	public List<User> findUserAll(int pageNo, int pageSize);
}
