package com.jvwl.examination.dto;

import com.jvwl.examination.bean.UserLevel;

/**
 * @author 蹇伟
 */
public class UserDTO {

	private String username;
	private String password;
	private UserLevel level;
	private String date1;
	private String date2;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
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
		return "UserDTO [date1=" + date1 + ", date2=" + date2 + ", level="
				+ level + ", password=" + password + ", username=" + username
				+ "]";
	}

}
