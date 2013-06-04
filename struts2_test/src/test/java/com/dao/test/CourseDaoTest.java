package com.dao.test;

import java.sql.SQLException;

import org.junit.Test;

import com.jvwl.test.dao.CourseDao;
import com.jvwl.test.dto.CourseDto;
import com.jvwl.test.dto.PageInfo;
import com.jvwl.test.dto.Pagination;
import com.jvwl.test.model.Course;

public class CourseDaoTest {
	CourseDao courseDao = new CourseDao();

	@Test
	public void testAdd() throws SQLException {
		Course course = new Course();
		course.setC_id("2003");
		course.setC_name("中方");
		course.setC_memo("没有");
		courseDao.add(course);
	}

	@Test
	public void testUpdate() throws SQLException {
		Course course = new Course();
		course.setId(1);
		course.setC_id("2001");
		course.setC_name("中方2");
		course.setC_memo("没有2");
		courseDao.update(course);
	}

	@Test
	public void testDelete() throws SQLException {
		courseDao.delete(1);
	}

	@Test
	public void testFindCourseById() throws SQLException {
		System.out.println(courseDao.findCourseById(2));
	}

	@Test
	public void testFindCourseByC_id() throws SQLException {
		System.out.println(courseDao.findCourseByC_id("2001"));
	}

	@Test
	public void testFindCourses() throws SQLException {
		CourseDto courseDto = new CourseDto();
		courseDto.setC_id("2001");
		PageInfo pageInfo = new PageInfo(1, 10);
		Pagination<Course> pagination = courseDao.findCourses(courseDto, pageInfo);
		System.out.println(pagination);
		//System.out.println(pagination.getList());
	}

}
