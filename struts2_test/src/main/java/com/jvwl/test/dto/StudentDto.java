package com.jvwl.test.dto;

import java.util.Date;

public class StudentDto {

	private Integer id;
	private String s_id;
	private String s_name;
	private Boolean s_sex;
	private Date s_birthday;
	private Date s_birthday2;

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

	public Date getS_birthday2() {
		return s_birthday2;
	}

	public void setS_birthday2(Date sBirthday2) {
		s_birthday2 = sBirthday2;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", s_birthday=" + s_birthday
				+ ", s_birthday2=" + s_birthday2 + ", s_id=" + s_id
				+ ", s_name=" + s_name + ", s_sex=" + s_sex + "]";
	}

}
