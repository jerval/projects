package com.jvwl.examination.service;

import java.io.Serializable;
import java.util.List;

import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.model.BaseBean;

public interface IBaseService<T extends BaseBean> {

	public void save(T t);

	public void update(T t);

	public void delete(T t);

	public int executeUpdate(String hql, Object... params);

	public T find(Class<T> clazz, Serializable id);

	public T findClass(Class<T> clazz, Serializable id);

	public long getTotalElements(String jpql, Object... params);

	public List<T> query(String jpql, PageInfo pageInfo, Object... params);

}
