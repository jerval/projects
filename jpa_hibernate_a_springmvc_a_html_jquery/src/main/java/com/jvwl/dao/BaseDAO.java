package com.jvwl.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jvwl.dto.PageInfo;
import com.jvwl.exception.BusinessException;
import com.jvwl.model.BaseBean;
import com.jvwl.util.EMFactory;

public class BaseDAO<T extends BaseBean> {
	private Log log = LogFactory.getLog(this.getClass());

	public void add(T t) {
		EntityManager entityManager = EMFactory.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			log.info("保存信息:" + t);
			entityManager.persist(t);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			log.error(e.getMessage());
			throw new BusinessException("保存信息失败");
		} finally {
			if (entityManager != null && entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}

	public void update(T t) {
		EntityManager entityManager = EMFactory.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			log.info("更新信息:" + t);
			entityManager.merge(t);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			log.error(e.getMessage());
			throw new BusinessException("更新信息失败");
		} finally {
			if (entityManager != null && entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}

	public void delete(Class<T> clazz, Serializable[] ids) {
		if (ids != null && ids.length > 0) {
			StringBuffer sb = new StringBuffer("delete from ");
			sb.append(clazz.getSimpleName()).append(" where id in(");
			for (Serializable id : ids) {
				sb.append("'").append(id).append("',");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append(")");
			String hql = sb.toString();
			EntityManager entityManager = EMFactory.getEntityManager();
			EntityTransaction tx = entityManager.getTransaction();
			try {
				tx.begin();
				log.info("删除信息 hql:" + hql);
				entityManager.createQuery(hql).executeUpdate();
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
				log.error(e.getMessage());
				throw new BusinessException("删除信息失败,可能部分数据无法删除！");
			} finally {
				if (entityManager != null && entityManager.isOpen()) {
					entityManager.close();
				}
			}
		}
	}

	public int executeUpdate(String jpql, Object... params) {
		EntityManager entityManager = EMFactory.getEntityManager();
		Query query = entityManager.createQuery(jpql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.executeUpdate();
	}

	public T find(Class<T> clazz, Serializable id) {
		return EMFactory.getEntityManager().getReference(clazz, id);
	}

	public T findClass(Class<T> clazz, Serializable id) {
		EntityManager entityManager = EMFactory.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		T t = entityManager.find(clazz, id);
		tx.commit();
		return t;
	}

	public long getTotalElements(String jpql, Object... params) {
		Query query = EMFactory.getEntityManager().createQuery(jpql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i+1, params[i]);
		}
		Long max = (Long) query.getSingleResult();
		long maxElements = 0;
		if (max != null) {
			maxElements = max.longValue();
		}
		log.info("BaseDAO-getTotalElements():jpql:" + jpql);
		log.info("maxElements:" + maxElements);
		return maxElements;
	}

	@SuppressWarnings("unchecked")
	public List<T> query(String jpql, PageInfo pageInfo, Object... params) {
		Query query = EMFactory.getEntityManager().createQuery(jpql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		if (pageInfo != null) {
			query.setFirstResult((pageInfo.getPageNo() - 1)
					* pageInfo.getPageSize());
			query.setMaxResults(pageInfo.getPageSize());
		}
		List<T> list = query.getResultList();
		log.info("BaseDAO-query():jpql:" + jpql + pageInfo);
		log.info("list.size:" + list.size());
		return list;
	}
}
