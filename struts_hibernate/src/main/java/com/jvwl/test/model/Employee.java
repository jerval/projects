package com.jvwl.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jvwl.test.bean.EmployeeLevel;
import com.jvwl.test.bean.Gender;
import com.jvwl.test.bean.YesNo;

@SuppressWarnings("serial")
@Entity
@Table(name="t_employee")
public class Employee extends BaseBean {
	private String emp_id;// 员工ID
	private String emp_name;// 员工姓名
	private Gender gender;// 员工性别
	private Department department;// 员工所属部门
	private EmployeeLevel level;// 员工级别
	private Date birthday;// 员工生日
	private String phone;// 电话号码
	private String email;// Email
	private String address;// 员工地址
	private String contact;// 备用联系方式
	private String memo;// 备注
	private String password;// 密码
	private YesNo dep_manager;// 是否是部门管理人员

	@Column(length=20,nullable=false,unique=true)
	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String empId) {
		emp_id = empId;
	}

	@Column(length=20,nullable=false)
	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String empName) {
		emp_name = empName;
	}

	@Column(length=2,nullable=false)
	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@ManyToOne(optional=false)
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(length=10,nullable=false)
	@Enumerated(EnumType.STRING)
	public EmployeeLevel getLevel() {
		return level;
	}

	public void setLevel(EmployeeLevel level) {
		this.level = level;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(length=20,unique=true)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length=20,unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length=100)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(length=100)
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(length=200)
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(length=30)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING)
	@Column(length=20,nullable=false)
	public YesNo getDep_manager() {
		return dep_manager;
	}

	public void setDep_manager(YesNo depManager) {
		dep_manager = depManager;
	}

}
