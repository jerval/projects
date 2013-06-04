package com.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mybatis.app.model.Student;
import com.mybatis.app.service.StudentService;

public class TestStudent {

	private static StudentService studentService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentService = new StudentService();
	}

	@Test
	public void testAdd() {
		studentService.add(new Student(null, "jerval", new Date()));
	}

	@Test
	public void testUpdate() {
		studentService.update(new Student(1, "jerval", new Date()));
	}

	@Test
	public void testDelete() {
		studentService.delete(11);
	}

	@Test
	public void testFindById() {
		Student student = studentService.findById(9);
		System.out.println(student);
	}

	@Test
	public void testFindByPage() {
		List<Student> students = studentService.findByPage(1, 5);
		System.out.println(students);
		System.out.println(students.size());
	}
	
	@Test
	public void testFindNamesByPage() {
		List<String> names = studentService.findNamesByPage(1, 5);
		System.out.println(names);
		System.out.println(names.size());
	}
	@Test
	public void testFindByPage2() {
		List<Map<String, Object>> results = studentService.findCommonByPage(1, 5);
		System.out.println(results);
		System.out.println(results.size());
	}
	@Test
	public void testFindByPage3() {
		List<Object> results = studentService.findBySql("com.mybatis.app.mapper.StudentMapper.findById",5);
		System.out.println(results);
		System.out.println(results.size());
	}
}
