package com.jerval.service;

import java.util.List;

import com.jerval.bean.Teacher;

public interface TeacherService {

	public void save(Teacher teacher);

	public void update(Teacher teacher);

	public void delete(Integer id);

	public Teacher findTeacher(Integer id);

	public List<Teacher> findTeachers(Integer pageNo, Integer pageSize);
}
