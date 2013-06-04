package com.dao.test;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.jvwl.test.dao.StudentDao;
import com.jvwl.test.dto.PageInfo;
import com.jvwl.test.dto.Pagination;
import com.jvwl.test.dto.StudentDto;
import com.jvwl.test.model.Student;


public class StudentDaoTest {
	StudentDao studentDao = new StudentDao();

	@Test
	public void testAdd() {
		Student student = new Student();
		student.setS_id("10013");
		student.setS_name("李四");
		student.setS_sex(true);
		student.setS_birthday(new Date());
		student.setS_memo("这是一个测试");
		try {
			studentDao.add(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Student student = new Student();
		student.setId(3);
		student.setS_id("10013");
		student.setS_name("李四2");
		student.setS_sex(true);
		student.setS_birthday(new Date());
		student.setS_memo("这测试");
		try {
			studentDao.update(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			studentDao.delete(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFindStudentById() throws SQLException {
		System.out.println(studentDao.findStudentById(1));
	}

	@Test
	public void testFindStudentByS_id() throws SQLException {
		System.out.println(studentDao.findStudentByS_id("10013"));
	}

	@Test
	public void testFindStudents() throws SQLException {
		StudentDto studentDTO = new StudentDto();
		studentDTO.setS_sex(true);
		PageInfo pageInfo = new PageInfo(1, 10);
		Pagination<Student> pagination = studentDao.findStudents(studentDTO, pageInfo);
		System.out.println(pagination);
		System.out.println(pagination.getList());
	}

}
