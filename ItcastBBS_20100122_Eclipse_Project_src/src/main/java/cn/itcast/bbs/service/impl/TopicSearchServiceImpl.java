package cn.itcast.bbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bbs.domain.SearchableTopic;
import cn.itcast.bbs.domain.Topic;
import cn.itcast.bbs.domain.query.PageView;
import cn.itcast.bbs.domain.query.QueryResult;
import cn.itcast.bbs.search.base.GenericIndexDao;
import cn.itcast.bbs.service.TopicSearchService;
import cn.itcast.bbs.service.base.ServiceImplBase;

@Service("topicSearchService")
public class TopicSearchServiceImpl extends ServiceImplBase<Topic> implements TopicSearchService {
	@Resource(name = "topicIndexDao")
	private GenericIndexDao<SearchableTopic> topicIndexDao;

	public PageView getPageView(String queryString, int pageNum, int pageSize) {
		int firstResult = PageView.calculateFirstResult(pageNum, pageSize);
		QueryResult<SearchableTopic> qr = topicIndexDao.search(queryString, firstResult, pageSize);
		if (qr.getRecordCount() == 0) {
			return PageView.EMPTY_PAGE_VIEW;
		}

		int totalPage = (qr.getRecordCount() + pageSize - 1) / pageSize;
		if (pageNum > totalPage) { // 指定的页码超过总页码时，显示最后一页
			pageNum = totalPage;
			firstResult = PageView.calculateFirstResult(totalPage, pageSize);
			qr = topicIndexDao.search(queryString, firstResult, pageSize);
		}

		return new PageView(pageNum, pageSize, qr.getRecordCount(), qr.getRecordList());
	}

	public int getCount() {
		return topicIndexDao.getCount();
	}

	public static int MAX_RECREATE_ENTITY_COUNT_ONCE = 100;

	@SuppressWarnings("unchecked")
	@Transactional
	public void reCreateAll() {
		// 一次取一部分，以防止内存溢出
		int pageSize = MAX_RECREATE_ENTITY_COUNT_ONCE;
		int topicCount = super.getCount();

		for (int i = 0; i < topicCount; i += pageSize) {
			List<Topic> topicList = getSession().createCriteria(Topic.class)//
					.add(Restrictions.eq("deleted", false))//
					.addOrder(Order.asc("postTime"))// 按发表时间升序排列，这样就是从前向后进行索引，期间新发表了主题也没关生系
					.setFirstResult(i)// firstResult = i
					.setMaxResults(pageSize)//
					.list();

			List<SearchableTopic> searchableTopicList = new ArrayList<SearchableTopic>();
			for (int j = 0; j < topicList.size(); j++) {
				searchableTopicList.add(new SearchableTopic(topicList.get(j)));
			}

			super.flushAndClearSession();
			topicIndexDao.saveAll(searchableTopicList);
		}
	}

}