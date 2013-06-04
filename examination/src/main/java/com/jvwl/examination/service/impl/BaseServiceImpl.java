package com.jvwl.examination.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.jvwl.examination.dao.IBaseDAO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.model.BaseBean;
import com.jvwl.examination.service.IBaseService;

@Component("baseService")
public class BaseServiceImpl<T extends BaseBean> implements IBaseService<T> {
	protected Log log = LogFactory.getLog(this.getClass());
	protected IBaseDAO<T> baseDAO;

	@Resource
	public void setBaseDAO(IBaseDAO<T> baseDAO) {
		this.baseDAO = baseDAO;
	}

	@Override
	public void save(T t) {
		log.info("开始保存数据：" + t);
		baseDAO.persist(t);
		log.info("保存数据完成：" + t);
	}

	@Override
	public void update(T t) {
		log.info("开始修改数据：" + t);
		baseDAO.merge(t);
		log.info("修改数据完成：" + t);
	}

	@Override
	public void delete(T t) {
		log.info("开始删除数据：" + t);
		baseDAO.remove(t);
		log.info("删除数据完成：" + t);
	}

	@Override
	public int executeUpdate(String hql, Object... params) {
		log.info("执行更新语句：" + hql);
		return baseDAO.executeUpdate(hql, params);
	}

	@Override
	public T find(Class<T> clazz, Serializable id) {
		return baseDAO.find(clazz, id);
	}

	@Override
	public T findClass(Class<T> clazz, Serializable id) {
		return baseDAO.findClass(clazz, id);
	}

	@Override
	public long getTotalElements(String jpql, Object... params) {
		log.info("查询总数------jpql:" + jpql);
		return baseDAO.getTotalElements(jpql, params);
	}

	@Override
	public List<T> query(String jpql, PageInfo pageInfo, Object... params) {
		log.info("查询数据------jpql:" + jpql+",pageInfo:"+pageInfo);
		return baseDAO.query(jpql, pageInfo, params);
	}

}
