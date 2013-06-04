package com.jvwl.forum.service;

import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.dto.UserDto;
import com.jvwl.forum.model.User;
import com.jvwl.forum.service.base.BaseService;

public interface UserService extends BaseService<User> {
	
	public Pagination<User> findUsers(UserDto dto, PageInfo pageInfo);

	public Pagination<User> findUsers(UserDto dto, PageInfo pageInfo,
			Boolean deleted);
}
