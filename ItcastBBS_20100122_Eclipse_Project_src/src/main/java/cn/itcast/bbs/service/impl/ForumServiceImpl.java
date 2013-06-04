package cn.itcast.bbs.service.impl;

import java.io.Serializable;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bbs.domain.Category;
import cn.itcast.bbs.domain.Forum;
import cn.itcast.bbs.exception.NotEmptyServiceException;
import cn.itcast.bbs.service.ForumService;
import cn.itcast.bbs.service.base.ServiceImplBase;

/**
 * @author 传智播客.汤阳光 Jun 6, 2008 5:48:24 PM
 */
@Service("forumService")
@Transactional
public class ForumServiceImpl extends ServiceImplBase<Forum> implements ForumService {

	@Override
	public void save(Forum forum) {
		// 设置order值并保存
		forum.setOrder(super.getMaxValue("order") + 1);
		getSession().persist(forum);

		// 双向设置，因为还有集合缓存
		forum.getCategory().getForums().add(forum);
		getSession().merge(forum.getCategory());
	}

	@Override
	public void update(Forum forum) {
		super.update(forum);
		// 有可能是修改的所属分类，这样要清除所有分类的forums的集合缓存
		getSession().getSessionFactory().evictCollection(Category.class.getName()+".forums");
	}

	@Override
	public void delete(Serializable id) throws NotEmptyServiceException {
		Forum forum = this.getById(id);
		if (forum.getTopicCount() > 0) {
			throw new NotEmptyServiceException("此版面中含有主题，不能被删除!");
		}
		getSession().delete(forum);

		// 双向删除，因为还有集合缓存
		forum.getCategory().getForums().remove(this);
		getSession().merge(forum.getCategory());
	}

	public boolean move(String id, boolean isUp) {
		Forum forum = this.getById(id);
		Forum other = isUp ? findPreviousByOrder(forum) : findNextByOrder(forum);

		// 最上面的版面不能上移, 最下面的版面不能下移
		if (other == null) {
			return false;
		}

		// 交换显示顺序
		int tempOrder = forum.getOrder();
		forum.setOrder(other.getOrder());
		other.setOrder(tempOrder);
		return true;
	}

	/**
	 * 查询排在当前版面前面的版面
	 * 
	 * @param forum
	 * @return
	 */
	private Forum findPreviousByOrder(Forum forum) {
		return (Forum) getSession().createCriteria(Forum.class)//
				.add(Restrictions.eq("this.category", forum.getCategory()))//
				.add(Restrictions.lt("order", forum.getOrder()))//
				.addOrder(Order.desc("order"))//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
	}

	/**
	 * 查询排在当前版面后面的版面
	 * 
	 * @param forum
	 * @return
	 */
	private Forum findNextByOrder(Forum forum) {
		return (Forum) getSession().createCriteria(Forum.class)//
				.add(Restrictions.eq("this.category", forum.getCategory()))//
				.add(Restrictions.gt("order", forum.getOrder()))//
				.addOrder(Order.asc("order"))//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
	}

}
