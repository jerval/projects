package com.jvwl.jdbc.model;

public class Student {
	private Integer id;
	private String stu_id;
	private String stu_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stuId) {
		stu_id = stuId;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stuName) {
		stu_name = stuName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", stu_id=" + stu_id + ", stu_name="
				+ stu_name + "]";
	}

}
