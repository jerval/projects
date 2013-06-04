package com.jvwl.test.model;

public class Course {

	private Integer id;
	private String c_id;
	private String c_name;
	private String c_memo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String cId) {
		c_id = cId;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String cName) {
		c_name = cName;
	}
	public String getC_memo() {
		return c_memo;
	}
	public void setC_memo(String cMemo) {
		c_memo = cMemo;
	}
	@Override
	public String toString() {
		return "Course [c_id=" + c_id + ", c_memo=" + c_memo + ", c_name="
				+ c_name + ", id=" + id + "]";
	}
	
}
