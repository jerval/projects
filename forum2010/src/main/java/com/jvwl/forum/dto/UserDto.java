package com.jvwl.forum.dto;

import com.jvwl.forum.bean.UserType;

public class UserDto {
	private String username;// 用户名
	private UserType type;// 类型：管理员：0，普通用户：1

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "UserDto [type=" + type + ", username=" + username + "]";
	}

}
