package cn.itcast.bbs.dao.base;

import java.io.Serializable;
import java.util.List;

import cn.itcast.bbs.domain.query.CriteriaBean;
import cn.itcast.bbs.domain.query.QueryResult;

public interface DaoBase<T> {

	/**
	 * 刷出并清空Session
	 */
	void flushAndClearSession();

	/**
	 * 保存实体
	 */
	void save(T o);

	/**
	 * 删除实体
	 */
	void delete(Serializable id);

	/**
	 * 更新实体
	 */
	void update(T o);

	/**
	 * 获取指定 id 的实体
	 */
	T getById(Serializable id);

	<E> E getById(Class<E> clazz, Serializable id);

	/**
	 * 根据 idList 获取多个实体
	 */
	List<T> getByIdList(Serializable[] idList);

	// <E> List<E> getByIdList(Class<E> clazz, Serializable[] idList);

	/**
	 * 获取所有记录
	 */
	List<T> findAll();

	// <E> List<E> findAll(Class<E> clazz);

	/**
	 * 查询记录总数
	 * 
	 * @return
	 */
	int getCount();

	/**
	 * 让指定记录的某属性值递增指定数量
	 * 
	 * @param id
	 * @param propertyName 此属性要是数字类型
	 * @param step 步长
	 */
	void increment(Serializable id, String propertyName, int step);

	/** 让指定记录的某属性值递增1 */
	void increment(Serializable id, String propertyName);

	/**
	 * 查询
	 * 
	 * @param criteriaBean 条件
	 * @return
	 */
	QueryResult<T> getQueryResultByCriteriaBean(CriteriaBean criteriaBean);

	int getCountByCriteriaBean(CriteriaBean criteriaBean);

	List<T> getListByCriteriaBean(CriteriaBean criteriaBean);
}
