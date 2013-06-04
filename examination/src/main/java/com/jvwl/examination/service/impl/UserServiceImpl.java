package com.jvwl.examination.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jvwl.examination.bean.UserLevel;
import com.jvwl.examination.dto.LoginInfo;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.dto.UserDTO;
import com.jvwl.examination.model.BaseBean;
import com.jvwl.examination.service.IUserService;

@Component("userService")
public class UserServiceImpl<T extends BaseBean> extends BaseServiceImpl<T>
		implements IUserService<T> {

	@Override
	public T findByUsername(String username) {
		String jpql = " from User u where u.username=?";
		List<T> list = query(jpql, new PageInfo(1, 1), username);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}


	public T login(LoginInfo loginInfo) {
		String jpql = " from User u where u.username=? and u.password=? ";
		List<T> list = query(jpql, new PageInfo(1, 1), new Object[] {
			loginInfo.getUsername(), loginInfo.getPassword()});
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Pagination<T> findUsers(UserDTO uDto, PageInfo pageInfo) {
		String sqlwhere = getSQL(uDto);
		String jpql = " from User u where 1=1 " + sqlwhere+ " order by u.id desc";
		List<T> list = query(jpql, pageInfo);
		jpql = " select count(*) from User u where 1=1 " + sqlwhere;
		long maxElements = getTotalElements(jpql);
		Pagination<T> pagination = new Pagination<T>(null, maxElements,
				pageInfo.getPageNo(), pageInfo.getPageSize());
		if (maxElements > 0) {
			pagination.setList(list);
		}
		return pagination;
	}

	private String getSQL(UserDTO uDto) {
		StringBuilder sql = new StringBuilder();
		if (uDto == null) {
			return "";
		} else {
			String username = uDto.getUsername();
			UserLevel level = uDto.getLevel();
			String date1 = uDto.getDate1();
			String date2 = uDto.getDate2();
			if (null != username && !"".equals(username)) {
				sql.append(" and u.username like '%" + username + "%'");
			}
			if (null != level && !"".equals(level.name())) {
				sql.append(" and u.level ='" + level.name() + "'");
			}
			if (null != date1 && null != date2 && !"".equals(date1)
					&& !"".equals(date2)) {
				sql.append(" and u.dateCreated between '" + date1 + " 00:00:00' and '"
						+ date2 + " 00:00:00'");
			} else if (null != date1 && !"".equals(date1)
					&& (null == date2 || "".equals(date2))) {
				sql.append(" and u.dateCreated >= '" + date1 + " 00:00:00'");
			} else if (null != date2 && !"".equals(date2)
					&& (null == date1 || "".equals(date1))) {
				sql.append(" and u.dateCreated <= '" + date2 + " 00:00:00'");
			}
			return sql.toString();
		}
	}
}
