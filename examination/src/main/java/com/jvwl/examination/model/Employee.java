package com.jvwl.examination.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.jvwl.examination.bean.EmployeeLevel;
import com.jvwl.examination.bean.Gender;
import com.jvwl.examination.bean.YesNo;
import com.jvwl.examination.util.TimeUtil;

/**
 * 保存员工信息的javabean
 * 
 * @author 蹇伟
 * 
 */
@SuppressWarnings("serial")
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

	@Enumerated(EnumType.STRING)
	@Column(nullable = false,length=2)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@ManyToOne(cascade = CascadeType.REFRESH, optional = false, targetEntity = Department.class)
	@JoinColumn(name = "depart_id")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable=false,length=20)
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

	@Transient
	public String getStrBirthday() {
		return TimeUtil.getDate(birthday);
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(length = 14, nullable = false)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 30)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 50)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(length = 14)
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

	@Column(length = 40, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable=false,length=2)
	public YesNo getDep_manager() {
		return dep_manager;
	}

	public void setDep_manager(YesNo depManager) {
		dep_manager = depManager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emp_id == null) ? 0 : emp_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (emp_id == null) {
			if (other.emp_id != null)
				return false;
		} else if (!emp_id.equals(other.emp_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [address=" + address + ", birthday=" + birthday
				+ ", contact=" + contact + ", dep_manager=" + dep_manager
				+ ", department=" + department + ", email=" + email
				+ ", emp_id=" + emp_id + ", emp_name=" + emp_name + ", gender="
				+ gender + ", level=" + level + ", memo=" + memo
				+ ", password=" + password + ", phone=" + phone
				+ ", dateCreated=" + dateCreated + ", dateUpdate=" + dateUpdate
				+ ", id=" + id + ", version=" + version + "]";
	}

}
