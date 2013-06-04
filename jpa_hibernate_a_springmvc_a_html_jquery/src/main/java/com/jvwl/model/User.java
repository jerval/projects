package com.jvwl.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jvwl.bean.UserLevel;

@Entity
@Table(name="t_user")
public class User {

	private String username;// 用户名
	private String password;// 密码
	private UserLevel level;// 用户级别：管理员，部门经理，普通员工

	@Id
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserLevel getLevel() {
		return level;
	}

	public void setLevel(UserLevel level) {
		this.level = level;
	}

}
