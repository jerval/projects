package com.jvwl.dto;

import com.jvwl.bean.EmployeeLevel;
import com.jvwl.bean.Gender;
import com.jvwl.bean.YesNo;
import com.jvwl.model.Department;

public class EmployeeDTO {

	private String emp_id;// 员工ID
	private String emp_name;// 员工姓名
	private Gender gender;// 员工性别
	private Department department;// 员工所属部门
	private String birthday1;// 生日起始时间
	private String birthday2;// 生日结束时间
	private String phone;// 电话号码
	private String email;// Email
	private EmployeeLevel level;// 员工级别
	private YesNo dep_manager;// 是否是部门管理人员

	public String getBirthday1() {
		return birthday1;
	}

	public void setBirthday1(String birthday1) {
		this.birthday1 = birthday1;
	}

	public String getBirthday2() {
		return birthday2;
	}

	public void setBirthday2(String birthday2) {
		this.birthday2 = birthday2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public YesNo getDep_manager() {
		return dep_manager;
	}

	public void setDep_manager(YesNo depManager) {
		dep_manager = depManager;
	}

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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public EmployeeLevel getLevel() {
		return level;
	}

	public void setLevel(EmployeeLevel level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [birthday1=" + birthday1 + ", birthday2="
				+ birthday2 + ", dep_manager=" + dep_manager + ", department="
				+ department + ", email=" + email + ", emp_id=" + emp_id
				+ ", emp_name=" + emp_name + ", gender=" + gender + ", level="
				+ level + ", phone=" + phone + "]";
	}

}
