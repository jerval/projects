package com.jvwl.train.dto;


/**
 * 部门招聘计划履历dto
 * 
 * @author hejie
 * 
 */

public class DepartWantedPlanHistoryDto{
	/**
	 * 计划年度
	 */
	private String year;
	/**
	 * 部门编号
	 */
	private String departmentId;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "DepartWantedPlanHistoryDto [departmentId=" + departmentId
				+ ", year=" + year + "]";
	}
	
}
