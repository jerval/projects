package com.jvwl.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jvwl.bean.Pagination;
import com.jvwl.dao.ObjectDao;
import com.jvwl.exception.BusinessException;
import com.jvwl.util.QLHandler;

public class ObjectDaoImpl<T> extends SuperDaoSupport implements ObjectDao<T> {

	public void addObject(T t) {
		getHibernateTemplate().save(t);
	}

	public void updateObject(T t) {
		getHibernateTemplate().update(t);
	}

	public void deleteObjects(Class<T> clazz, List<Serializable> ids) {
		int i = 0;
		HibernateTemplate template = getHibernateTemplate();
		for (Serializable id : ids) {
			template.delete(findObject(clazz, id));
			if (i > 20) {
				template.clear();
				i = 0;
			}
			i++;
		}
	}

	@SuppressWarnings("unchecked")
	public T findObject(Class<T> clazz, Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public Pagination<T> findObjects(Class<T> clazz, Map<String, Object> map,
			int pageNum, int pageSize) {
		QLHandler qlHandler = new QLHandler();
		Query query = getSession(false)
				.createQuery(qlHandler.getQL(clazz, map)).setFirstResult(
						(pageNum - 1) * pageSize).setMaxResults(pageSize);
		qlHandler.setParameter(query, map);
		Query query1 = getSession(false).createQuery(
				qlHandler.getQLCount(clazz, map));
		qlHandler.setParameter(query1, map);
		long maxElements = (Long) query1.uniqueResult();
		Pagination<T> pagination = new Pagination<T>(query.list(), pageNum,
				pageSize, maxElements);
		return pagination;
	}

	public long getMaxElements() {

		return 0;
	}

	@SuppressWarnings("unchecked")
	public Pagination<T> findObjectsStrict(Class<T> clazz,
			Map<String, Object> map, int pageNum, int pageSize) {
		QLHandler qlHandler = new QLHandler();
		Query query = getSession(false).createQuery(
				qlHandler.getQLStrict(clazz, map)).setFirstResult(
				(pageNum - 1) * pageSize).setMaxResults(pageSize);
		qlHandler.setParameterStrict(query, map);
		Query query1 = getSession(false).createQuery(
				qlHandler.getQLStrictCount(clazz, map));
		qlHandler.setParameterStrict(query1, map);
		long maxElements = (Long) query1.uniqueResult();
		Pagination<T> pagination = new Pagination<T>(query.list(), pageNum,
				pageSize, maxElements);
		return pagination;
	}

	public void notExistObject(Class<T> clazz, Serializable id) {
		if (getHibernateTemplate().get(clazz, id) == null) {
			// Handler Exception by custom RuntimeException
			BusinessException.notExistException(clazz, id);
		}
	}

	public void existObject(Class<T> clazz, Serializable id) {
		if (getHibernateTemplate().get(clazz, id) != null) {
			BusinessException.existException(clazz, id);
		}
	}
}
