package com.jvwl.train.dao.base;

import java.io.Serializable;
import java.util.List;

import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.model.base.BaseBean;

/**
 * 数据访问基类接口
 * 
 * @author jerval
 */
public interface BaseDao<T extends BaseBean> {

	/**
	 * 保存实体对象
	 * @param t：任意继承BaseBean的实体
	 */
	public void save(T t);
	/**
	 * 更新实体对象
	 * @param t：任意继承BaseBean的实体
	 */
	public void update(T t);
	/**
	 * 通过实体id删除实体对象
	 * @param ids：实体id的数组
	 * @return 删除实体成功的个数
	 */
	public int delete(Serializable[] ids);
	/**
	 * 执行jpql，包含DDL
	 * @param jpql：要执行的jpql
	 * @param params：jpql中要传入的参数
	 * @return 执行后在数据库影响的行数
	 */
	public int executeUpdate(String jpql, Object... params);
	/**
	 * 通过实体id查找实体，lazy模式
	 * @param id：实体的id
	 * @return：查找到的实体对象，如果不存在则抛出异常
	 */
	public T findById(Serializable id);
	/**
	 * 通过实体id查找实体，非lazy模式
	 * @param id：实体的id
	 * @return：查找到的实体对象，如果不存在则为null
	 */
	public T findClassById(Serializable id);
	/**
	 * 通过实体id查找任意实体（未继），非lazy模式
	 * @param <E>：实体类
	 * @param clazz：实体的类类型
	 * @param id：实体的id
	 * @return：查找到的实体对象，如果不存在则为null
	 */
	public <E> E findClassById(Class<E> clazz, Serializable id);
	/**
	 * 查找多个实体通过不同的实体id
	 * @param ids：多个实体的id
	 * @return：查找到的实体对象的List封装
	 */
	public List<T> findByIds(Serializable[] ids);
	/**
	 * 查找所有已删除实体或查找所有未删除实体
	 * @param deleted：true为已删除的，反之为未删除的
	 * @return：所有实体List的封装
	 */
	public List<T> findAll(Boolean deleted);
	/**
	 * 通过id对实体上的属性值加步长
	 * @param id：实体id
	 * @param propertyName：实体属性名称
	 * @param step：要加的步长
	 */
	public void increment(Serializable id, String propertyName, int step);
	/**
	 * 通过id对实体上的属性值加步长1
	 * @param id：实体id
	 * @param propertyName：实体属性名称
	 */
	public void increment(Serializable id, String propertyName);
	/**
	 * 返回查询结果的总记录数
	 * @param jpql：要执行查询的JPQL语句
	 * @param params：JPQL参数，可有可无
	 * @return：总记录数
	 */
	public long getTotalElements(String jpql, Object... params);
	/**
	 * 返回查询结果集
	 * @param jpql：要执行查询的JPQL语句
	 * @param pageInfo：封装了pageSize和pageNo的javabean
	 * @param params：JPQL参数，可有可无
	 * @return：通过jpql查到的实体的List封装
	 */
	public List<T> query(String jpql, PageInfo pageInfo, Object... params);
	/**
	 * 通过查询条件和PageBean查找未删除的实体
	 * @param sqlWhere：查询条件
	 * @param pageInfo：封装了pageSize和pageNo的javabean
	 * @return：封装了Pagebean和实体List的封装类
	 */
	public Pagination<T> findEntities(String sqlWhere, PageInfo pageInfo);
	/**
	 * 通过查询条件和PageBean查找删除或未删除的实体
	 * @param sqlWhere：查询条件
	 * @param pageInfo：封装了pageSize和pageNo的javabean
	 * @param deleted：true为已删除，false未删除
	 * @return：封装了Pagebean和实体List的封装类
	 */
	public Pagination<T> findEntities(String sqlWhere, PageInfo pageInfo,
			Boolean deleted);
}
