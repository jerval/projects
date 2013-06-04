package com.jvwl.forum.service.impl;

import org.springframework.stereotype.Service;

import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.dto.TopicDto;
import com.jvwl.forum.model.Topic;
import com.jvwl.forum.service.TopicService;
import com.jvwl.forum.service.base.BaseServiceImpl;
@Service("topicService")
public class TopicServiceImpl extends BaseServiceImpl<Topic> implements
		TopicService {
	public Pagination<Topic> findTopics(TopicDto dto, PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
	}

	public Pagination<Topic> findTopics(TopicDto dto, PageInfo pageInfo,
			Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);
	}

	public String getSqlWhere(TopicDto dto) {
		return "";
	}

}
