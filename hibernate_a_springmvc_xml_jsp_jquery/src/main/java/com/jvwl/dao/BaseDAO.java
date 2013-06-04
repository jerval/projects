package com.jvwl.dao;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.jvwl.dto.PageInfo;
import com.jvwl.exception.BusinessException;
import com.jvwl.model.BaseBean;
import com.jvwl.util.HibernateUtils;

public class BaseDAO<T extends BaseBean> {
	private Log log = LogFactory.getLog(this.getClass());

	public void add(T t) {
		Session session = HibernateUtils.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			log.info("保存信息:" + t);
			session.persist(t);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			log.error(e.getMessage());
			throw new BusinessException("保存信息失败");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void update(T t) {
		Session session = HibernateUtils.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			log.info("更新信息:" + t);
			session.update(t);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			log.error(e.getMessage());
			throw new BusinessException("更新信息失败");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void delete(T t) {
		Session session = HibernateUtils.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			log.info("删除信息:" + t);
			session.delete(t);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			log.error(e.getMessage());
			throw new BusinessException("删除信息失败");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
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
			Session session = HibernateUtils.getSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				log.info("删除信息 hql:" + hql);
				session.createQuery(hql).executeUpdate();
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
				log.error(e.getMessage());
				throw new BusinessException("删除信息失败,可能部分数据未删除！");
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
		}
	}

	public int executeUpdate(String hql, Object... params) {
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public T find(Class<T> clazz, Serializable id) {
		return (T) HibernateUtils.getSession().load(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public T findClass(Class<T> clazz, Serializable id) {
		return (T) HibernateUtils.getSession().get(clazz, id);
	}

	public long getTotalElements(String jpql, Object... params) {
		Query query = HibernateUtils.getSession().createQuery(jpql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		Long max = (Long) query.uniqueResult();
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
		Query query = HibernateUtils.getSession().createQuery(jpql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		if (pageInfo != null) {
			query.setFirstResult((pageInfo.getPageNo() - 1)
					* pageInfo.getPageSize());
			query.setMaxResults(pageInfo.getPageSize());
		}
		List<T> list = query.list();
		log.info("BaseDAO-query():jpql:" + jpql + pageInfo);
		log.info("list.size:" + list.size());
		return list;
	}
}
