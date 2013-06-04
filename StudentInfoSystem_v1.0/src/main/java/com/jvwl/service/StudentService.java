package com.jvwl.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.jvwl.bean.Pagination;
import com.jvwl.model.Student;

public interface StudentService {

	public void addStudent(Student student, String username);

	public void updateStudent(Student student, String username);

	public void deleteStudent(List<Serializable> ids, String username);

	public Student findStudent(String id);

	public Pagination<Student> findStudents(Map<String, Object> map, int pageNum,
			int pageSize);

}