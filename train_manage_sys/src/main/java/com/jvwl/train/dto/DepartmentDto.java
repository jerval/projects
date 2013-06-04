package com.jvwl.train.dto;


/**
 * 部门dto
 * @author hejie
 *
 */
public class DepartmentDto {
	/**
	 * 部门编号
	 */
	private String departmentId;
	/**
	 * 部门名称
	 */
	private String departmentName;

	public String getDepartmentName() {
		return departmentName;
	}

	

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "DepartmentDto [departmentId=" + departmentId
				+ ", departmentName=" + departmentName + "]";
	}

	
}
