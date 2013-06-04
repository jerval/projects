package cn.itcast.bbs.utils;

import cn.itcast.bbs.domain.Role;
import cn.itcast.bbs.domain.SystemPrivilege;
import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.utils.domain.MemberUtils;

public class PrivilegeCheckUtils {

	/**
	 * 检查用户是否有指定的权限
	 * 
	 * @param user 当前登录用户
	 * @param resource
	 * @param action
	 * @return
	 */
	public static boolean checkPrivilege(User user, String resource, String action) {
		if (user == null) { // 未登录用户，没有权限
			return false;
		}

		// 超级管理员有所有权限，不可更改
		if(MemberUtils.isSuperman(user)){
			return true;
		}
		
		for (Role role : user.getRoles()) {
			for (SystemPrivilege sp : role.getSystemPrivileges()) {
				// 是否有对某资源的某操作的权限
				if (sp.getResource().equals(resource) && sp.getAction().equals(action)) {
					return true;
				}
			}
		}
		return false;
	}
}
