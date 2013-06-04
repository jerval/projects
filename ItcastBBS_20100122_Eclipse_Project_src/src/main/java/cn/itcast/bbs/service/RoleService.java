package cn.itcast.bbs.service;

import java.util.List;
import java.util.Set;

import cn.itcast.bbs.domain.Role;
import cn.itcast.bbs.domain.SystemPrivilege;
import cn.itcast.bbs.service.base.ServiceBase;

public interface RoleService extends ServiceBase<Role> {

	/**
	 * 获取所有的系统权限
	 * @return
	 */
	List<SystemPrivilege> getAllSystemPrivileges();

	/**
	 * 获取指定id的系统权限
	 * @param systemPrivilegeIdList
	 * @return
	 */
	Set<SystemPrivilege> getSystemPrivilegeByIdList(String[] systemPrivilegeIdList);

}
