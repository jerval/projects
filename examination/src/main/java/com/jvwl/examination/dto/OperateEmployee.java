package com.jvwl.examination.dto;

import com.jvwl.examination.model.Department;

/**
 * 
 * @author 蹇伟
 */
public class OperateEmployee {

	private String emp_id;// 员工ID
	private String emp_name;// 员工姓名
	private Department department;// 员工所属部门
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String empId) {
		emp_id = empId;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String empName) {
		emp_name = empName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
