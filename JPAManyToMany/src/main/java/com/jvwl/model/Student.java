package com.jvwl.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/*
 * 学生表，关系的维护端
 */
@Entity
public class Student {
	private Integer id;
	private String name;
	private Set<Teacher> teachers = new HashSet<Teacher>();

	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 10, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "student_teacher", inverseJoinColumns = @JoinColumn(name = "tid"), joinColumns = @JoinColumn(name = "sid"))
	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public void addTeacher(Teacher teacher){
		teachers.add(teacher);
	}
	public void removeTeacher(Teacher teacher){
		//要能判断出是否包含在Set中，必须重写Teacher中的hashCode方法和equals方法
		if(teachers.contains(teacher)){
			teachers.remove(teacher);
		}
	}
}
