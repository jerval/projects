package com.jvwl.examination.dto;

import com.jvwl.examination.bean.UserLevel;

/**
 *用户登录时保存用户登录信息
 * 
 * @author 蹇伟
 */
public class OperateUser {

	private String username;
	private UserLevel level;

	public OperateUser(){}
	
	public OperateUser(String username, UserLevel level) {
		this.username = username;
		this.level = level;
	}

	public UserLevel getLevel() {
		return level;
	}

	public void setLevel(UserLevel level) {
		this.level = level;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserDTO [level=" + level 
				+ ", username=" + username + "]";
	}
	
}
