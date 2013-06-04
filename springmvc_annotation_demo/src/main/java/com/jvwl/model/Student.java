package com.jvwl.model;

public class Student {

	private String stu_no;
	private String stu_name;

	public String getStu_no() {
		return stu_no;
	}

	public void setStu_no(String stuNo) {
		stu_no = stuNo;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stuName) {
		stu_name = stuName;
	}

	@Override
	public String toString() {
		return "Studnet [stu_name=" + stu_name + ", stu_no=" + stu_no + "]";
	}

}
