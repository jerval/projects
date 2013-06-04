package com.jvwl.test.dto;

public class CourseDto {
	private Integer id;
	private String c_id;
	private String c_name;
	
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
	@Override
	public String toString() {
		return "CourseDTO [c_id=" + c_id + ", c_name=" + c_name + ", id=" + id
				+ "]";
	}
	
}
