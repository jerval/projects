package com.jvwl.train.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.model.base.BaseBean;

/**
 * 数据访问基类实现
 * @author jerval
 */
@Transactional
public abstract class BaseDaoImpl<T extends BaseBean> implements BaseDao<T> {

	private Class<T> entityClass;
	private EntityManager em;
	private Log log = LogFactory.getLog(this.getClass());

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		this.entityClass = (Class<T>) pt.getActualTypeArguments()[0];
	}

	protected Class<T> getEntityClass() {
		return this.entityClass;
	}

	protected String getEntityName() {
		return getEntityClass().getSimpleName();
	}

	public void save(T t) {
		em.persist(t);
	}

	public void update(T t) {
		em.merge(t);
	}

	public int getMaxValue(String propertyName) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("select max(").append(propertyName).append(") from ")
				.append(getEntityName());
		log.info("BaseDAO-getMaxValue():jpql:" + jpql);
		Object result = em.createQuery(jpql.toString()).getSingleResult();
		int maxValue = (result == null) ? 0 : ((Number) result).intValue();
		return maxValue;
	}

	public int executeUpdate(String jpql, Object... params) {
		Query query = em.createQuery(jpql);
		for (Object obj : params) {
			query.setParameter(1, obj);
		}
		return query.executeUpdate();
	}

	public long getTotalElements(String jpql, Object... params) {
		Query query = em.createQuery(jpql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}
		Long max = (Long) query.getSingleResult();
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

		Query query = em.createQuery(jpql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}
		if (pageInfo != null) {
			query.setFirstResult((pageInfo.getPageNo() - 1)
					* pageInfo.getPageSize());
			query.setMaxResults(pageInfo.getPageSize());
		}
		List<T> list = query.getResultList();
		log.info("BaseDAO-query():jpql:" + jpql + pageInfo);
		log.info("list.size:" + list.size());
		return list;
	}

	public int delete(Serializable[] ids) {
		if (ids != null && ids.length > 0) {
			StringBuffer jpql = new StringBuffer("delete from ");
			jpql.append(getEntityName()).append(" e where e.id in('-1'");
			for (Serializable id : ids) {
				jpql.append(",'").append(id).append("'");
			}
			jpql.append(")");
			log.info("BaseDAO-delete():jpql:" + jpql);
			return em.createQuery(jpql.toString()).executeUpdate();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Boolean deleted) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("from ").append(getEntityName());
		if (deleted) {
			jpql.append(" where deleted=1");
		} else {
			jpql.append(" where deleted=0");
		}
		return (List<T>) em.createQuery(jpql.toString()).getResultList();
	}

	public T findById(Serializable id) {
		return em.getReference(entityClass, id);
	}

	public T findClassById(Serializable id) {
		return em.find(entityClass, id);
	}

	public <E> E findClassById(Class<E> clazz, Serializable id) {
		return em.getReference(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByIds(Serializable[] ids) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("from " + getEntityName() + " e where e.id in ('-1'");
		for (Serializable id : ids) {
			jpql.append(",'").append(id).append("'");
		}
		jpql.append(")");
		log.info("BaseDAO-findByIdList():jpql:" + jpql);
		return (List<T>) em.createQuery(jpql.toString()).getResultList();
	}

	public void increment(Serializable id, String propertyName) {
		increment(id, propertyName, 1);
	}

	public void increment(Serializable id, String propertyName, int step) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("update ").append(getEntityName()).append(" e  set e.")
				.append(propertyName).append("=e.").append(propertyName)
				.append("+").append(step).append(" where e.id='").append(id)
				.append("'");
		log.info("BaseDAO-increment():jpql:" + jpql);
		em.createQuery(jpql.toString());
	}

	public Pagination<T> findEntities(String sqlWhere, PageInfo pageInfo) {
		return findEntities(sqlWhere, pageInfo, false);
	}
	public Pagination<T> findEntities(String sqlWhere, PageInfo pageInfo,
			Boolean deleted){
		if (deleted) {
			sqlWhere += " and e.deleted=1";
		} else {
			sqlWhere += " and e.deleted=0";
		}
		StringBuffer jpql = new StringBuffer();
		jpql.append(" from ").append(getEntityName()).append(" e where 1=1 ")
				.append(sqlWhere).append(" order by e.id desc");
		List<T> list = query(jpql.toString(), pageInfo);
		jpql = new StringBuffer();
		jpql.append(" select count(*) from ").append(getEntityName()).append(
				" e where 1=1 ").append(sqlWhere);
		long maxElements = getTotalElements(jpql.toString());
		Pagination<T> pagination = new Pagination<T>(null, maxElements,
				pageInfo.getPageNo(), pageInfo.getPageSize());
		if (maxElements > 0) {
			pagination.setList(list);
		}
		return pagination;
	}
}
