package com.jvwl.test.service;

import java.sql.SQLException;

import com.jvwl.test.dao.CourseDao;
import com.jvwl.test.dto.CourseDto;
import com.jvwl.test.dto.PageInfo;
import com.jvwl.test.dto.Pagination;
import com.jvwl.test.model.Course;

public class CourseService {
	private CourseDao courseDao = new CourseDao();

	public void add(Course course) throws SQLException {
		courseDao.add(course);
	}

	public void update(Course course) throws SQLException {
		courseDao.update(course);
	}

	public void delete(int id) throws SQLException {
		courseDao.delete(id);
	}

	public Course findCourseById(int id) throws SQLException {
		return courseDao.findCourseById(id);
	}

	public Course findCourseByC_id(String c_id) throws SQLException {
		return courseDao.findCourseByC_id(c_id);
	}

	public Pagination<Course> findCourses(CourseDto courseDTO, PageInfo pageInfo)
			throws SQLException {
		return courseDao.findCourses(courseDTO, pageInfo);
	}
}
