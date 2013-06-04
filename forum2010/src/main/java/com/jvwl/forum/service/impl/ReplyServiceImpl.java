package com.jvwl.forum.service.impl;

import org.springframework.stereotype.Service;

import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.dto.ReplyDto;
import com.jvwl.forum.model.Reply;
import com.jvwl.forum.service.ReplyService;
import com.jvwl.forum.service.base.BaseServiceImpl;
@Service("replyService")
public class ReplyServiceImpl extends BaseServiceImpl<Reply> implements
		ReplyService {

	public Pagination<Reply> findReplys(ReplyDto dto, PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
	}

	public Pagination<Reply> findReplys(ReplyDto dto, PageInfo pageInfo,
			Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);
	}

	public String getSqlWhere(ReplyDto dto) {
		return "";
	}
}
