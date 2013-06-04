package com.jvwl.forum.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jvwl.forum.bean.UserType;
import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.dto.UserDto;
import com.jvwl.forum.model.User;
import com.jvwl.forum.service.UserService;
import com.jvwl.forum.service.base.BaseServiceImpl;

@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	public Pagination<User> findUsers(UserDto dto, PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
	}

	public Pagination<User> findUsers(UserDto dto, PageInfo pageInfo,
			Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);
	}

	public String getSqlWhere(UserDto dto) {
		StringBuilder sql = new StringBuilder();
		if (dto == null) {
			return "";
		} else {
			String username = dto.getUsername();
			UserType type = dto.getType();
			if (null != username && !"".equals(username)) {
				sql.append(" and e.username like '%" + username + "%'");
			}
			if (null != type) {
				sql.append(" and e.type=" + type);
			}
			return sql.toString();
		}
	}
}
