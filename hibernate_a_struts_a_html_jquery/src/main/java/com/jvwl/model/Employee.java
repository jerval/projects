package com.jvwl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jvwl.bean.EmployeeLevel;
import com.jvwl.bean.Gender;
import com.jvwl.bean.YesNo;

@Entity
@Table(name = "t_employee")
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

	@Column(nullable = false, unique = true, length = 20)
	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String empId) {
		emp_id = empId;
	}

	@Column(nullable = false, length = 20)
	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String empName) {
		emp_name = empName;
	}

	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.ORDINAL)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "departmentId", nullable = false)
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.ORDINAL)
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

	@Column(length = 11)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 200)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(length = 100)
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(length = 200)
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(length = 30)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.ORDINAL)
	public YesNo getDep_manager() {
		return dep_manager;
	}

	public void setDep_manager(YesNo depManager) {
		dep_manager = depManager;
	}

	@Override
	public String toString() {
		return "Employee [address=" + address + ", birthday=" + birthday
				+ ", contact=" + contact + ", dep_manager=" + dep_manager
				+ ", department=" + department + ", email=" + email
				+ ", emp_id=" + emp_id + ", emp_name=" + emp_name + ", gender="
				+ gender + ", level=" + level + ", memo=" + memo
				+ ", password=" + password + ", phone=" + phone + "]";
	}

}
