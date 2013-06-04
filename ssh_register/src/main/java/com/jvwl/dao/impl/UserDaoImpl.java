package com.jvwl.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.jvwl.dao.UserDao;
import com.jvwl.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {
	private HibernateTemplate hibernateTemplate;

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void addUser(User user) {
		hibernateTemplate.save(user);
	}

}
