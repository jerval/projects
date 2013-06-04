package cn.itcast.bbs.search.base;

import java.io.Serializable;
import java.util.List;

import cn.itcast.bbs.domain.query.QueryResult;

public interface GenericIndexDao<T> {

	/**
	 * 保存实体
	 * 
	 * @param searchableObject
	 */
	void save(T searchableObject);

	void saveAll(List<T> searchableObjectList);

	/**
	 * 删除实体
	 * 
	 * @param searchableObject
	 */
	void delete(T searchableObject);

	void delete(Serializable id);

	void deleteAll(List<T> searchableObjectList);

	/**
	 * 更新实体
	 * 
	 * @param searchableObject
	 */
	void update(T searchableObject);

	/**
	 * 查询
	 * 
	 * @param queryString 不能为null或空字符串
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	QueryResult<T> search(String queryString, int firstResult, int maxResults);

	// QueryResult<T> search(CompassQuery query, int firstResult, int maxResults);

	/**
	 * @return 索引的总数量
	 */
	int getCount();
}
