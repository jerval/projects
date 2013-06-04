package com.jdbc.factory;

import java.util.List;

import com.jdbc.domain.User;
import com.jdbc.exception.BusinessException;

/**
 * 
 * @author Jerval
 * 
 * @date 2011-6-1
 */
public class UserService {

	private IUserDao userDao;

	public UserService() {
		userDao = (IUserDao) DaoFactory.get("userDao");
		if(null==userDao){
			throw new BusinessException("userDao is null!");
		}
	}

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	public User findUserById(Integer id) {
		return userDao.findUserById(id);
	}

	public List<User> findUserAll(int pageNo, int pageSize) {
		return userDao.findUserAll(pageNo, pageSize);
	}

}
