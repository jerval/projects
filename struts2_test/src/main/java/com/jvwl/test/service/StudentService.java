package com.jvwl.test.service;

import java.sql.SQLException;

import com.jvwl.test.dao.StudentDao;
import com.jvwl.test.dto.PageInfo;
import com.jvwl.test.dto.Pagination;
import com.jvwl.test.dto.StudentDto;
import com.jvwl.test.model.Student;

public class StudentService {
	private StudentDao studentDao = new StudentDao();

	public void add(Student student) throws SQLException {
		studentDao.add(student);
	}

	public void update(Student student) throws SQLException {
		studentDao.update(student);
	}

	public void delete(int id) throws SQLException {
		studentDao.delete(id);
	}

	public Student findStudentById(int id) throws SQLException {
		return studentDao.findStudentById(id);
	}

	public Student findStudentByS_id(String s_id) throws SQLException {
		return studentDao.findStudentByS_id(s_id);
	}

	public Pagination<Student> findStudents(StudentDto studentDTO,
			PageInfo pageInfo) throws SQLException {
		return studentDao.findStudents(studentDTO, pageInfo);
	}
}
