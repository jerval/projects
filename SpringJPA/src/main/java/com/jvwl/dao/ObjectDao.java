package com.jvwl.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component("objectDao")
public class ObjectDao<T> extends BaseDao{
	
	public void save(T t) {
		em.persist(t);
	}

	public void update(T t) {
		em.merge(t);
	}

	public void delete(Class<T> clazz, Serializable id) {
		em.remove(em.getReference(clazz, id));
	}
}
