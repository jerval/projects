package com.jvwl.forum.service;

import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.dto.ReplyDto;
import com.jvwl.forum.model.Reply;
import com.jvwl.forum.service.base.BaseService;

public interface ReplyService extends BaseService<Reply>{
	public Pagination<Reply> findReplys(ReplyDto dto,
			PageInfo pageInfo) ;
	public Pagination<Reply> findReplys(ReplyDto dto,
			PageInfo pageInfo,Boolean deleted) ;
}
