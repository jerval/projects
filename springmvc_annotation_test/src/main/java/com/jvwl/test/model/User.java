package com.jvwl.test.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public class User {

	@NotEmpty(message="用户名不能为空")
	private String username;
	@Size(max=20,min=6,message="密码长度不正确")
	private String password;

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

}
