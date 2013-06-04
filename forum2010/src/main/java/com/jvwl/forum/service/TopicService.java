package com.jvwl.forum.service;

import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.dto.TopicDto;
import com.jvwl.forum.model.Topic;
import com.jvwl.forum.service.base.BaseService;

public interface TopicService extends BaseService<Topic>{
	public Pagination<Topic> findTopics(TopicDto dto,
			PageInfo pageInfo) ;
	public Pagination<Topic> findTopics(TopicDto dto,
			PageInfo pageInfo,Boolean deleted) ;
}
