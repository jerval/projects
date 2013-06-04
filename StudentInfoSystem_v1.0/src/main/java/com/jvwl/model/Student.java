package com.jvwl.model;

/*
 * 学生基本信息
 */
public class Student {
	private String studentId; // 学号
	private String name; // 姓名
	private StudentGender gender = StudentGender.BOY; // 性别
	private int age;
	private String phone;
	private String email;
	private String address;
	private Clazz clazz; // 班级
	private int version;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudentGender getGender() {
		return gender;
	}

	public void setGender(StudentGender gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
}
