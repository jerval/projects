package cn.itcast.bbs.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bbs.domain.Category;
import cn.itcast.bbs.exception.NotEmptyServiceException;
import cn.itcast.bbs.service.CategoryService;
import cn.itcast.bbs.service.base.ServiceImplBase;

/**
 * @author 传智播客.汤阳光 Jun 6, 2008 5:46:23 PM
 */
@Service("categoryService")
@Transactional
public class CategoryServiceImpl extends ServiceImplBase<Category> implements CategoryService {

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> findAll() {
		return getSession().createCriteria(Category.class)//
				.addOrder(Order.asc("order"))//
				.setCacheable(true)//
				.list();
	}

	@Override
	public void save(Category category) {
		// 设置order值并保存
		category.setOrder(getMaxValue("order") + 1);
		getSession().persist(category);
	}

	@Override
	public void delete(Serializable id) throws NotEmptyServiceException {
		Category c = this.getById(id);
		if (c.getForums().size() > 0) {// 如果分类含有版面, 不能删除
			throw new NotEmptyServiceException("此分类中含有版面，不能被删除");
		}
		getSession().delete(c);
	}

	public boolean move(String id, boolean isUp) {
		Category c = this.getById(id);
		Category other = isUp ? findPreviousByOrder(c) : findNextByOrder(c);

		// 最上面的分类不能上移, 最下面的分类不能下移
		if (other == null) {
			return false;
		}

		// 4. 交换显示顺序
		int tempOrder = c.getOrder();
		c.setOrder(other.getOrder());
		other.setOrder(tempOrder);
		return true;
	}

	/**
	 * 查询排在当前分类前面的分类
	 * 
	 * @param category
	 * @return
	 */
	private Category findPreviousByOrder(Category category) {
		return (Category) getSession().createCriteria(Category.class)//
				.add(Restrictions.lt("order", category.getOrder()))//
				.addOrder(Order.desc("order"))//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
	}

	/**
	 * 查询排在当前分类后面的分类
	 * 
	 * @param category
	 * @return
	 */
	private Category findNextByOrder(Category category) {
		return (Category) getSession().createCriteria(Category.class)//
				.add(Restrictions.gt("order", category.getOrder()))//
				.addOrder(Order.asc("order"))//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
	}
}
