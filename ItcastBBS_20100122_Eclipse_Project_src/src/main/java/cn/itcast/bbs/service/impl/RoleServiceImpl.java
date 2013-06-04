package cn.itcast.bbs.service.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bbs.domain.Role;
import cn.itcast.bbs.domain.SystemPrivilege;
import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.exception.NotEmptyServiceException;
import cn.itcast.bbs.service.RoleService;
import cn.itcast.bbs.service.base.ServiceImplBase;

@Service("roleService")
@Transactional
@SuppressWarnings("unchecked")
public class RoleServiceImpl extends ServiceImplBase<Role> implements RoleService {

	@Override
	public void delete(Serializable id) {
		int userCount = ((Number) getSession().createCriteria(User.class)//
				.createCriteria("roles")//
				.add(Restrictions.eq("id", id))//
				.setProjection(Projections.rowCount())//
				.uniqueResult()).intValue();
		if (userCount > 0) {
			throw new NotEmptyServiceException("有用户属于此角色，不能被删除");
		}
		Object role = getSession().get(Role.class, id);
		getSession().delete(role);
	}

	public List<SystemPrivilege> getAllSystemPrivileges() {
		return getSession().createCriteria(SystemPrivilege.class)//
				.list();
	}

	public Set<SystemPrivilege> getSystemPrivilegeByIdList(String[] systemPrivilegeIdList) {
		if (systemPrivilegeIdList == null || systemPrivilegeIdList.length == 0) {
			return Collections.EMPTY_SET;
		}

		List list = getSession().createCriteria(SystemPrivilege.class)//
				.add(Restrictions.in("id", systemPrivilegeIdList))//
				.list();
		return new HashSet<SystemPrivilege>(list);
	}

}
