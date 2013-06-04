package com.jvwl.daoimpl.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.jvwl.dao.PageDao;
import com.jvwl.util.HibernateUtil;

public class PageDaoImpl implements PageDao {

	private int pageSize;
	private int pageNum;
	private String entityName;
	private Session session = null;

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	@Override
	public List getList() {
		session = HibernateUtil.getSession();
		List list = session.createQuery("from "+entityName+" order by id")
		.setFirstResult(pageSize * (pageNum-1))
		.setMaxResults(pageSize)
		.list();
		session.close();
		return list;
	}

	@Override
	public int getMaxElements() {
		session = HibernateUtil.getSession();
		Long total = (Long) session.createQuery("select count(*) from "+entityName).uniqueResult();
		session.close();
		return total.intValue();
	}

	@Override
	public int getMaxPages() {
		int total = getMaxElements();
		return total%pageSize==0?total/pageSize:total/pageSize+1;
	}

	@Override
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public int getPageSize() {
		return pageSize;
	}

}
