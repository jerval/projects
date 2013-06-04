package com.jvwl.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.jvwl.bean.Pagination;
import com.jvwl.dao.ObjectDao;
import com.jvwl.exception.BusinessException;
import com.jvwl.util.QLHandler;

@Component("objectDao")
@Scope("prototype")
public class ObjectDaoImpl<T> extends BaseDaoImpl implements ObjectDao<T> {

	public void addObject(T t) {
		em.persist(t);
	}

	public void updateObject(T t) {
		em.merge(t);
	}

	public void deleteObjects(Class<T> clazz, List<Serializable> ids) {
		int i = 0;
		for (Serializable id : ids) {
			em.remove(em.getReference(clazz, id));
			if (i > 20) {
				em.clear();
				i = 0;
			}
			i++;
		}
	}

	public T findObject(Class<T> clazz, Serializable id) {
		return (T) em.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public Pagination<T> findObjects(Class<T> clazz, Map<String, Object> map,
			int pageNum, int pageSize) {
		QLHandler qlHandler = new QLHandler();
		Query query = em.createQuery(qlHandler.getQL(clazz, map))
				.setFirstResult((pageNum - 1) * pageSize).setMaxResults(
						pageSize);
		qlHandler.setParameter(query, map);
		Query query1 = em.createQuery(qlHandler.getQLCount(clazz, map));
		qlHandler.setParameter(query1, map);
		long maxElements = (Long) query1.getSingleResult();
		Pagination<T> pagination = new Pagination<T>(query.getResultList(),
				pageNum, pageSize, maxElements);
		return pagination;
	}

	public long getMaxElements() {

		return 0;
	}

	@SuppressWarnings("unchecked")
	public Pagination<T> findObjectsStrict(Class<T> clazz,
			Map<String, Object> map, int pageNum, int pageSize) {
		QLHandler qlHandler = new QLHandler();
		Query query = em.createQuery(qlHandler.getQLStrict(clazz, map))
				.setFirstResult((pageNum - 1) * pageSize).setMaxResults(
						pageSize);
		qlHandler.setParameterStrict(query, map);
		Query query1 = em.createQuery(qlHandler.getQLStrictCount(clazz, map));
		qlHandler.setParameterStrict(query1, map);
		long maxElements = (Long) query1.getSingleResult();
		Pagination<T> pagination = new Pagination<T>(query.getResultList(),
				pageNum, pageSize, maxElements);
		return pagination;
	}

	public void notExistObject(Class<T> clazz, Serializable id) {
		if (em.find(clazz, id) == null) {
			// Handler Exception by custom RuntimeException
			BusinessException.notExistException(clazz, id);
		}
	}

	public void existObject(Class<T> clazz, Serializable id) {
		if (em.find(clazz, id) != null) {
			BusinessException.existException(clazz, id);
		}
	}
}
