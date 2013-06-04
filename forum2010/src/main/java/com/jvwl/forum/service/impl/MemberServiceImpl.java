package com.jvwl.forum.service.impl;

import org.springframework.stereotype.Service;

import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.dto.MemberDto;
import com.jvwl.forum.model.Member;
import com.jvwl.forum.service.MemberService;
import com.jvwl.forum.service.base.BaseServiceImpl;

@Service("memberService")
public class MemberServiceImpl extends BaseServiceImpl<Member> implements
		MemberService {

	public Pagination<Member> findMembers(MemberDto dto, PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo, false);
	}

	public Pagination<Member> findMembers(MemberDto dto, PageInfo pageInfo,
			Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);
	}

	public String getSqlWhere(MemberDto dto) {
		return "";
	}
}
