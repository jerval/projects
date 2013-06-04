package com.jvwl.examination.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.jvwl.examination.bean.UserLevel;

/**
 * 保存用户信息的javabean
 * 
 * @author 蹇伟
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_user")
public class User extends BaseBean {

	private String username;//用户名
	private String password;//密码
	private UserLevel level;//用户级别：管理员，部门经理，普通员工

	@Column(nullable = false, unique = true, length = 32)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(nullable = false, length = 40)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING)
	@Column(length=12,nullable=false)
	public UserLevel getLevel() {
		return level;
	}

	public void setLevel(UserLevel level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "User [level=" + level + ", password=" + password
				+ ", username=" + username + ", dateCreated=" + dateCreated
				+ ", dateUpdate=" + dateUpdate + ", id=" + id + ", version="
				+ version + "]";
	}

}
