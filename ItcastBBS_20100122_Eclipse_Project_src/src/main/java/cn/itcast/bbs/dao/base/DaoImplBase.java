package cn.itcast.bbs.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bbs.domain.query.CriteriaBean;
import cn.itcast.bbs.domain.query.QueryResult;

/**
 * 提供的操作方法都是使用class的。在此类中的实现方法中，除了接受class的方法外，都是使用entity-name进行操作<br>
 * 使用 persist() 与 merge() 方法替代 save() 与 update() 方法。
 * 
 * @author tyg
 * @param <T>
 */
@Transactional
@SuppressWarnings("unchecked")
public abstract class DaoImplBase<T> extends HibernateDaoSupport implements DaoBase<T> {
	private Class<T> entityClass;

	public DaoImplBase() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		this.entityClass = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate_0(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}

	/**
	 * 刷出并清空Session
	 */
	public void flushAndClearSession() {
		getSession().flush();
		getSession().clear();
	}

	/**
	 * 保存实体
	 */
	public void save(T o) {
		getSession().persist(o);
	}

	/**
	 * 删除实体
	 */
	public void delete(Serializable id) {
		Object obj = getSession().load(getEntityName(), id);
		getSession().delete(obj);
	}

	/**
	 * 更新实体
	 */
	public void update(T o) {
		getSession().merge(o);
	}

	/**
	 * 获取指定 id 的实体
	 */

	public T getById(Serializable id) {
		return (T) getSession().get(getEntityName(), id);
	}

	public <E> E getById(Class<E> clazz, Serializable id) {
		return (E) getSession().get(clazz, id);
	}

	/**
	 * 根据 idList 获取多个实体
	 */
	public List<T> getByIdList(Serializable[] idList) {
		if (idList == null || idList.length == 0) {
			return Collections.EMPTY_LIST;
		}

		return getSession().createCriteria(getEntityName())//
				.add(Restrictions.in("id", idList))//
				.list();
	}

	// public <E> List<E> getByIdList(Class<E> clazz, Serializable[] idList) {
	// return getSession().createCriteria(clazz)//
	// .add(Restrictions.in("id", idList))//
	// .list();
	// }

	/**
	 * 获取所有记录
	 */
	public List<T> findAll() {
		return getSession().createCriteria(getEntityName()).list();
	}

	/**
	 * 查询记录总数
	 * 
	 * @return
	 */
	public int getCount() {
		return ((Number) getSession().createCriteria(getEntityName())//
				.setProjection(Projections.rowCount())//
				.uniqueResult())//
				.intValue();
	}

	/**
	 * 让指定的属性值递增指定数量
	 */
	public void increment(Serializable id, String propertyName, int step) {
		// FIXME 使用UPDATE语句实现的更新，这样是造成Session中的数据不同步吗？
		String hql = "UPDATE " + getEntityName() //
				+ " o SET o." + propertyName + " = o." + propertyName + " + " + step //
				+ " WHERE o.id = ?";
		getSession().createQuery(hql)//
				.setParameter(0, id)//
				.executeUpdate();
	}

	/** 让指定的属性值递增1 */
	public void increment(Serializable id, String propertyName) {
		increment(id, propertyName, 1);
	}

	/**
	 * 查询
	 * 
	 * @param criteriaBean 条件
	 * @return
	 */
	public QueryResult<T> getQueryResultByCriteriaBean(CriteriaBean criteriaBean) {
		int recordCount = criteriaBean.queryRecordCount(getSession(), getEntityName());
		List recordList = criteriaBean.queryRecordList(getSession(), getEntityName());
		return new QueryResult<T>(recordCount, recordList);
	}

	public int getCountByCriteriaBean(CriteriaBean criteriaBean) {
		return criteriaBean.queryRecordCount(getSession(), getEntityName());
	}

	public List<T> getListByCriteriaBean(CriteriaBean criteriaBean) {
		return criteriaBean.queryRecordList(getSession(), getEntityName());
	}

	/*****************************************************************************************************************************
	 * ** 实体信息
	 ****************************************************************************************************************************/

	/**
	 * entityClass可以自动检测
	 * 
	 * @return 实体的Class信息
	 */
	protected Class<T> getEntityClass() {
		return this.entityClass;
	}

	/**
	 * @return 实体名称，默认为类的全限定名
	 */
	protected String getEntityName() {
		return getEntityClass().getName();
	}

	/*****************************************************************************************************************************
	 * ** 工具方法
	 ****************************************************************************************************************************/

	/**
	 * 获取指定属性的最大值
	 * 
	 * @param propertyName
	 */
	public int getMaxValue(String propertyName) {
		Object result = getSession().createCriteria(getEntityName())//
				.setProjection(Projections.max(propertyName))//
				.uniqueResult();
		// 如果表中没有任何记录，会返回null。
		int maxValue = (result == null) ? 0 : ((Number) result).intValue();
		return maxValue;
	}
}
