package com.jvwl.test.model;

import java.util.Date;

public class Student {

	private Integer id;
	private String s_id;
	private String s_name;
	private Boolean s_sex;
	private Date s_birthday;
	private String s_memo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String sId) {
		s_id = sId;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String sName) {
		s_name = sName;
	}

	public Boolean getS_sex() {
		return s_sex;
	}

	public void setS_sex(Boolean sSex) {
		s_sex = sSex;
	}

	public Date getS_birthday() {
		return s_birthday;
	}

	public void setS_birthday(Date sBirthday) {
		s_birthday = sBirthday;
	}

	public String getS_memo() {
		return s_memo;
	}

	public void setS_memo(String sMemo) {
		s_memo = sMemo;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", s_birthday=" + s_birthday + ", s_id="
				+ s_id + ", s_memo=" + s_memo + ", s_name=" + s_name
				+ ", s_sex=" + s_sex + "]";
	}

}
