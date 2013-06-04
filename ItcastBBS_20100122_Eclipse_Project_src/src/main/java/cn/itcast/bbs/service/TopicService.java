package cn.itcast.bbs.service;

import cn.itcast.bbs.domain.Topic;
import cn.itcast.bbs.service.base.ServiceBase;

/**
 * @author 传智播客.汤阳光 Dec 15, 2008
 */
public interface TopicService extends ServiceBase<Topic> {

	/**
	 * 移动主题
	 * 
	 * @param id 要移动的主题的id
	 * @param destFourmId 目的版面的id
	 */
	void move(String id, String destForumId);

}
