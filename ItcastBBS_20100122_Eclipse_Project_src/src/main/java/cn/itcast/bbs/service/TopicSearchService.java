package cn.itcast.bbs.service;

import cn.itcast.bbs.domain.query.PageView;

public interface TopicSearchService {

	/**
	 * 查询分页信息
	 * 
	 * @param queryString
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageView getPageView(String queryString, int pageNum, int pageSize);

	/**
	 * 查询总数
	 * 
	 * @return
	 */
	int getCount();

	/**
	 * 重新创建所有主题的索引
	 */
	void reCreateAll();

}
