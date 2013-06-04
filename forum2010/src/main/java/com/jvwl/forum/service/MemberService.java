package com.jvwl.forum.service;

import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.dto.MemberDto;
import com.jvwl.forum.model.Member;
import com.jvwl.forum.service.base.BaseService;

public interface MemberService extends BaseService<Member>{
	public Pagination<Member> findMembers(MemberDto dto,
			PageInfo pageInfo) ;
	public Pagination<Member> findMembers(MemberDto dto,
			PageInfo pageInfo,Boolean deleted) ;
}
