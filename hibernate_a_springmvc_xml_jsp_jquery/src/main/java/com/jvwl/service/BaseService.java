package com.jvwl.service;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jvwl.dao.BaseDAO;
import com.jvwl.dto.PageInfo;
import com.jvwl.model.BaseBean;

public class BaseService<T extends BaseBean> {

	private BaseDAO<T> baseDAO = new BaseDAO<T>();
	private Log log = LogFactory.getLog(this.getClass());

	public void add(T t) {
		log.info("add" + t);
		baseDAO.add(t);
	}

	public void update(T t) {
		log.info("update" + t);
		baseDAO.update(t);
	}

	public void delete(T t) {
		log.info("delete" + t);
		baseDAO.delete(t);
	}

	public void delete(Class<T> clazz, Serializable[] ids) {
		baseDAO.delete(clazz, ids);
	}

	public int executeUpdate(String hql, Object... params) {
		log.info("executeUpdate hql:" + hql);
		return baseDAO.executeUpdate(hql, params);
	}

	public T find(Class<T> clazz, Serializable id) {
		log.info("find class:" + clazz + ",id:" + id);
		return baseDAO.find(clazz, id);
	}

	public T findClass(Class<T> clazz, Serializable id) {
		log.info("find class:" + clazz + ",id:" + id);
		return baseDAO.findClass(clazz, id);
	}

	public long getTotalElements(String jpql, Object... params) {
		log.info("查询总数------jpql:" + jpql);
		return baseDAO.getTotalElements(jpql, params);
	}

	public List<T> query(String jpql, PageInfo pageInfo, Object... params) {
		log.info("查询数据------jpql:" + jpql + ",pageInfo:" + pageInfo);
		return baseDAO.query(jpql, pageInfo, params);
	}
}
