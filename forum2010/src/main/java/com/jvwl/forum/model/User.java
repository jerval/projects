package com.jvwl.forum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.jvwl.forum.bean.UserType;
import com.jvwl.forum.model.base.BaseBean;

@Entity
@Table(name = "t_user")
public class User extends BaseBean {
	private String username;// 用户名
	private String password;// 密码
	private String repassword;
	private UserType type;// 类型：管理员：0，普通用户：1

	@Column(length = 20, nullable = false, unique = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(length = 30, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable=false)
	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "User [password=" + password + ", type=" + type + ", username="
				+ username + ", dateCreated=" + dateCreated + ", dateUpdate="
				+ dateUpdate + ", deleted=" + deleted + ", id=" + id
				+ ", version=" + version + "]";
	}
}
