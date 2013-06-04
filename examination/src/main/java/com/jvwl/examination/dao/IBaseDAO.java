package com.jvwl.examination.dao;

import java.io.Serializable;
import java.util.List;

import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.model.BaseBean;

public interface IBaseDAO<T extends BaseBean> {

	public void persist(T t);

	public void merge(T t);

	public void remove(T t);

	public int executeUpdate(String jpql, Object... params);

	public T find(Class<T> clazz, Serializable id);

	public T findClass(Class<T> clazz, Serializable id);

	public long getTotalElements(String jpql, Object... params);

	public List<T> query(String jpql, PageInfo pageInfo, Object... params);

}
