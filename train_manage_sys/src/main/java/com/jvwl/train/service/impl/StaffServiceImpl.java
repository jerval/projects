package com.jvwl.train.service.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.StaffDto;
import com.jvwl.train.model.Staff;
import com.jvwl.train.service.StaffService;
import com.jvwl.train.service.base.BaseServiceImpl;

/**
 * @author liuxin
 * 
 */
@Component("staffService")
public class StaffServiceImpl extends BaseServiceImpl<Staff, StaffDto>
		implements StaffService {

	public Pagination<Staff> findObjects(StaffDto dto, PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
	}

	public Pagination<Staff> findObjects(StaffDto dto, PageInfo pageInfo,
			Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);

	}

	public String getSqlWhere(StaffDto dto) {
		StringBuilder sql = new StringBuilder();
		if (dto == null) {
			return "";
		} else {
			String userId = dto.getUserId();
			String userName = dto.getUserName();
			String password = dto.getPassword();
			Date birthday = dto.getBirthday();
			Date birthday2 = dto.getBirthday2();
			if (null != userId && !"".equals(userId)) {
				sql.append(" and e.userId like '%" + userId + "%'");
			}
			if (null != userName && !"".equals(userName)) {
				sql.append(" and e.userName like '%" + userName + "%'");
			}
			if (null != password && !"".equals(password)) {
				sql.append(" and e.password like '%" + password + "%'");
			}
			if (null != birthday && null != birthday2) {
				sql.append(" and e.birthday between '" + birthday + "' and '"
						+ birthday2 + "'");
			} else if (null != birthday) {
				sql.append(" and e.birthday >='" + birthday + "'");
			} else if (null != birthday2) {
				sql.append(" and e.birthday <= '" + birthday2 + "'");
			}
			return sql.toString();
		}

	}

}
