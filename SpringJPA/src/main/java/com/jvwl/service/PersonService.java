package com.jvwl.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jvwl.dao.ObjectDao;
import com.jvwl.model.Person;
@Component("personService")
@Transactional
public class PersonService{
	private ObjectDao<Person> objectDao;

	public void add(Person person) {
		objectDao.save(person);
	}

	public void update(Person person) {
		objectDao.update(person);
	}

	public void delete(Class<Person> clazz, Serializable id) {
		objectDao.delete(clazz, id);
	}

	@Resource
	public void setObjectDao(ObjectDao<Person> objectDao) {
		this.objectDao = objectDao;
	}
}
