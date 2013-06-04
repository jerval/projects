package cn.itcast.bbs.domain.query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

/**
 * 查询条件Bean
 * 
 * @author tyg
 */
public class CriteriaBean {
	// pageNum 与 pageSize 只是在计算 firstResult 与 maxResults 用到。
	// 而 firstResult 与 maxResults 只是在分页查询中才用到
	private int pageNum;
	private int pageSize;

	private int firstResult;
	private int maxResults;

	public CriteriaBean() {
	}

	public CriteriaBean(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;

		this.firstResult = (pageNum - 1) * pageSize;
		this.maxResults = pageSize;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.firstResult = (pageNum - 1) * pageSize;
	}

	public CriteriaBean setFirstResult(int firstResult) {
		this.firstResult = firstResult;
		return this;
	}

	public CriteriaBean setMaxResults(int maxResults) {
		this.maxResults = maxResults;
		return this;
	}

	/**
	 * 过滤条件的集合
	 */
	private List<Criterion> criterionList = new ArrayList<Criterion>();

	/**
	 * 添加过滤条件
	 * 
	 * @param restriction
	 * @return this
	 */
	public CriteriaBean addRestriction(Criterion restriction) {
		criterionList.add(restriction);
		return this;
	}

	/**
	 * 排序的集合
	 */
	private List<Order> orderList = new ArrayList<Order>();

	/**
	 * 添加排序
	 * 
	 * @param order
	 * @return this
	 */
	public CriteriaBean addOrder(Order order) {
		orderList.add(order);
		return this;
	}

	/**
	 * 获取总记录数
	 * 
	 * @param session
	 * @param entityName
	 * @return
	 */
	public int queryRecordCount(Session session, String entityName) {
		return ((Number) buildCriteriaForQueryCount(session, entityName)//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.setProjection(Projections.rowCount())//
				.uniqueResult())//
				.intValue();
	}

	/**
	 * 获取相应的数据记录
	 * 
	 * @param session
	 * @param entityName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List queryRecordList(Session session, String entityName) {
		return buildCriteriaForQueryList(session, entityName)//
				.setProjection(null)// 去掉投影
				.setResultTransformer(Criteria.ROOT_ENTITY)//
				.list();
	}

	private DetachedCriteria detachedCriteria = null;

	public DetachedCriteria buildDetachedCriteria(String entityName) {
		detachedCriteria = DetachedCriteria.forEntityName(entityName);
		return detachedCriteria;
	}

	/**
	 * FIXME 查询count时不需加order by。如果加了，可以会在sql server中执行出错。例如，我遇到的为：<br>
	 * ORDER BY 子句中的列 "itcast_topic.lastArticlePostTime_" 无效，因为该列没有包含在聚合函数或 GROUP BY 子句中。 根据条件构建 Criteria 对象。<br>
	 * 可能会设置 firstResult 和 maxResults，这样会对 rowCount 造成影响。因为在获取select count时应使用first=0
	 * 
	 * @param session
	 * @param entityName
	 * @return
	 */
	// private Criteria buildCriteria(Session session, String entityName) {
	// Criteria criteria = null;
	// if (detachedCriteria == null) { // FIXME ??
	// criteria = session.createCriteria(entityName);
	// } else {
	// criteria = detachedCriteria.getExecutableCriteria(session);
	// }
	// // Criteria criteria = session.createCriteria(entityName);
	//
	// for (Criterion criterion : criterionList) {
	// criteria.add(criterion);
	// }
	//
	// for (Order order : orderList) {
	// criteria.addOrder(order);
	// }
	//
	// // FIXME firstResult 和 maxResults 会对 rowCount 造成影响。因为在获取select count时应使用first=0
	// if (firstResult > 0) {
	// criteria.setFirstResult(firstResult);
	// }
	// if (maxResults > 0) {
	// criteria.setMaxResults(maxResults);
	// }
	// return criteria;
	// }
	private Criteria buildCriteriaForQueryList(Session session, String entityName) {
		Criteria criteria = null;
		if (detachedCriteria == null) { // FIXME ??
			criteria = session.createCriteria(entityName);
		} else {
			criteria = detachedCriteria.getExecutableCriteria(session);
		}

		for (Criterion criterion : criterionList) {
			criteria.add(criterion);
		}

		for (Order order : orderList) {
			criteria.addOrder(order);
		}

		// FIXME firstResult 和 maxResults 会对 rowCount 造成影响。因为在获取select count时应使用first=0
		if (firstResult > 0) {
			criteria.setFirstResult(firstResult);
		}
		if (maxResults > 0) {
			criteria.setMaxResults(maxResults);
		}
		return criteria;
	}

	/**
	 * @param session
	 * @param entityName
	 * @return
	 */
	private Criteria buildCriteriaForQueryCount(Session session, String entityName) {
		Criteria criteria = null;
		if (detachedCriteria == null) { // FIXME ??
			criteria = session.createCriteria(entityName);
		} else {
			criteria = detachedCriteria.getExecutableCriteria(session);
		}

		for (Criterion criterion : criterionList) {
			criteria.add(criterion);
		}
		return criteria;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public int getMaxResults() {
		return maxResults;
	}

}
