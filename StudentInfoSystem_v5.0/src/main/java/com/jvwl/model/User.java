package com.jvwl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="t_user")
public class User {
	private String username;
	private String password;
	private UserType type = UserType.USER;

	@Id @Column(length=10)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(length=30)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING)
	@Column(length=10)
	public UserType getType() {
		return type;
	}

	@Transient
	public String getTypeString() {
		return type.toString();
	}

	public void setType(UserType type) {
		this.type = type;
	}
}
