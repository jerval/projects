package com.jvwl.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.jvwl.bean.Pagination;

public interface ObjectDao<T> {

	/**
	 * add a object
	 */
	public void addObject(T t);

	/**
	 * update a object
	 */
	public void updateObject(T t);

	/**
	 * delete some objects
	 */
	public void deleteObjects(Class<T> clazz, List<Serializable> ids);

	/**
	 * find a object
	 */
	public T findObject(Class<T> clazz, Serializable id);

	/**
	 * find some objects by your request on blur
	 */
	public Pagination<T> findObjects(Class<T> clazz, Map<String, Object> map,
			int pageNum, int pageSize);
	
	/**
	 * find some objects by your request strictly
	 */
	public Pagination<T> findObjectsStrict(Class<T> clazz, Map<String, Object> map,
			int pageNum, int pageSize);

	/**
	 * if the id not exist then throw RuntimeException.
	 * 
	 * @param clazz
	 *            the Class of your object which you want to find.
	 * @param id
	 *            the key of the object which has implements Serializable.
	 * @see com.jvwl.dao.ObjectDao#notExistObject(java.lang.Class,
	 *      java.io.Serializable)
	 */
	public void notExistObject(Class<T> clazz, Serializable id);

	/**
	 * if the id has exixted then throw RuntimeException.
	 * 
	 * @param clazz
	 *            the Class of your object which you want to find.
	 * @param id
	 *            the key of the object which has implements Serializable.
	 * @see com.jvwl.dao.ObjectDao#existObject(java.lang.Class,
	 *      java.io.Serializable)
	 */
	public void existObject(Class<T> clazz, Serializable id);

}