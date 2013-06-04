package com.jdbc.domain;

import java.sql.Timestamp;
import java.util.Date;

public class User {

	private Integer id;
	private String username;
	private String password;
	private Integer age;
	private Date regDate;

	public User() {
	}

	public User(Integer id) {
		super();
		this.id = id;
	}

	public User(Integer id, String username, Integer age, Date regDate) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.regDate = regDate;
	}

	public User(String username, String password, Integer age, Date regDate) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.regDate = regDate;
	}

	public User(Integer id, String username, String password, Integer age,
			Date regDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.regDate = regDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", age=" + age + ", regDate=" + regDate + "]";
	}

}
