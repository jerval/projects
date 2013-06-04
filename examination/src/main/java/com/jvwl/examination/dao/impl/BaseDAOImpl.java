package com.jvwl.examination.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.jvwl.examination.dao.IBaseDAO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.model.BaseBean;

/**
 *基本数据访问对象的实现
 * 
 * @author 蹇伟
 */
@Component("baseDAO")
public class BaseDAOImpl<T extends BaseBean> implements IBaseDAO<T> {

	private EntityManager em;
	private Log log = LogFactory.getLog(this.getClass());

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void persist(T t) {
		em.persist(t);
	}

	public void merge(T t) {
		em.merge(t);
	}

	public void remove(T t) {
		em.remove(t);
	}

	public int executeUpdate(String hql, Object... params) {
		Query query = em.createQuery(hql);
		for (Object obj : params) {
			query.setParameter(1, obj);
		}
		return query.executeUpdate();
	}

	public T find(Class<T> clazz, Serializable id) {
		return em.getReference(clazz, id);
	}

	public T findClass(Class<T> clazz, Serializable id) {
		return em.find(clazz, id);
	}

	@Override
	public long getTotalElements(String jpql, Object... params) {
		Query query = em.createQuery(jpql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}
		Long max = (Long) query.getSingleResult();
		long maxElements = 0;
		if (max != null) {
			maxElements = max.longValue();
		}
		log.info("BaseDAO-getTotalElements():jpql:"+jpql);
		log.info("maxElements:"+maxElements);
		return maxElements;
	}

	@SuppressWarnings("unchecked")
	public List<T> query(String jpql, PageInfo pageInfo, Object... params) {
		
		Query query = em.createQuery(jpql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}
		query.setFirstResult((pageInfo.getPageNo() - 1)
				* pageInfo.getPageSize());
		query.setMaxResults(pageInfo.getPageSize());
		List<T> list = query.getResultList();
		log.info("BaseDAO-query():jpql:"+jpql+pageInfo);
		log.info("list.size:"+list.size());
		return list;
	}
}
