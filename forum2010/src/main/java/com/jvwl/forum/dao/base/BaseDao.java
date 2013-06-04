package com.jvwl.forum.dao.base;

import java.io.Serializable;
import java.util.List;

import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.model.base.BaseBean;

public interface BaseDao<T extends BaseBean> {

	public void save(T t);

	public void update(T t);

	public int delete(Serializable[] ids);

	public int executeUpdate(String jpql, Object... params);

	public T findById(Serializable id);

	public T findClassById(Serializable id);

	public <E> E findClassById(Class<E> clazz, Serializable id);

	public List<T> findByIdList(Serializable[] idList);

	public List<T> findAll(Boolean deleted);

	public void increment(Serializable id, String propertyName, int step);

	public void increment(Serializable id, String propertyName);

	public long getTotalElements(String jpql, Object... params);

	public List<T> query(String jpql, PageInfo pageInfo, Object... params);

	public Pagination<T> findEntities(String sqlWhere, PageInfo pageInfo);

	public Pagination<T> findEntities(String sqlWhere, PageInfo pageInfo,
			Boolean deleted);
}
