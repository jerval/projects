package com.jvwl.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jvwl.bean.Pagination;
import com.jvwl.dao.ObjectDao;
import com.jvwl.model.Clazz;
import com.jvwl.model.Student;
import com.jvwl.service.StudentService;
@Component("studentService")
@Scope("prototype")
public class StudentServiceImpl extends BaseServiceImpl implements StudentService{
	private ObjectDao<Student> studentDao;
	private ObjectDao<Clazz> clazzDao;

	public void addStudent(Student student, String username) {
		clazzDao.notExistObject(Clazz.class, student.getClazz().getClassId());
		studentDao.existObject(Student.class, student.getStudentId());
		studentDao.addObject(student);
		saveLog(username, "添加学生：" + student.getStudentId());
	}

	public void updateStudent(Student student, String username) {
		clazzDao.notExistObject(Clazz.class, student.getClazz().getClassId());
		studentDao.updateObject(student);
		saveLog(username, "修改学生：" + student.getStudentId());
	}

	public void deleteStudent(List<Serializable> ids, String username) {
		studentDao.deleteObjects(Student.class, ids);
		saveLog(username, "删除学生：" + ids);
	}

	public Student findStudent(String id) {
		return studentDao.findObject(Student.class, id);
	}

	public Pagination<Student> findStudents(Map<String, Object> map,
			int pageNum, int pageSize) {
		return studentDao.findObjects(Student.class, map, pageNum,
				pageSize);
	}

	@Resource(name="objectDao")
	public void setStudentDao(ObjectDao<Student> studentDao) {
		this.studentDao = studentDao;
	}

	@Resource(name="objectDao")
	public void setClazzDao(ObjectDao<Clazz> clazzDao) {
		this.clazzDao = clazzDao;
	}
}
