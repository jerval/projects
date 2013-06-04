package cn.itcast.bbs.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色
 * 
 * @author 传智博客.汤阳光 Jun 19, 2008
 */
public class Role {
	private String id;
	private String name; // 名称
	private String description;// 描述
	private boolean defaultForNewUser;// 是否是新注册用户的默认角色
	private Set<SystemPrivilege> systemPrivileges = new HashSet<SystemPrivilege>(0);// 拥有的权限

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<SystemPrivilege> getSystemPrivileges() {
		return systemPrivileges;
	}

	public void setSystemPrivileges(Set<SystemPrivilege> systemPrivileges) {
		this.systemPrivileges = systemPrivileges;
	}

	public boolean isDefaultForNewUser() {
		return defaultForNewUser;
	}

	public void setDefaultForNewUser(boolean defaultForNewUser) {
		this.defaultForNewUser = defaultForNewUser;
	}

}
