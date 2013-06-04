package com.test;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

import com.jvwl.jdbc.dao.StudentDAO;
import com.jvwl.jdbc.model.Student;

public class StudentDAOTest {
	private static StudentDAO studentDAO;
	static {
		studentDAO = new StudentDAO();
	}

	@Test
	public void testAdd() throws SQLException {
		Student student = new Student();
		student.setId(333);
		student.setStu_id("888");
		student.setStu_name("kkkk");
		studentDAO.add(student);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindStudentById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindStudentByStu_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindStudents() {
		fail("Not yet implemented");
	}

}
