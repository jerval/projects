package com.jvwl.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.jvwl.bean.Pagination;
import com.jvwl.dao.ObjectDao;
import com.jvwl.model.Department;
import com.jvwl.model.Grade;
import com.jvwl.service.GradeService;

public class GradeServiceImpl extends BaseServiceImpl implements GradeService{
	private ObjectDao<Grade> gradeDao;
	private ObjectDao<Department> departmentDao;

	public void addGrade(Grade grade, String username) {
		departmentDao.notExistObject(Department.class, grade.getDepartment().getDepartmentId());
		gradeDao.existObject(Grade.class, grade.getGradeId());
		gradeDao.addObject(grade);
		saveLog(username, "添加系别：" + grade.getGradeId());
	}

	public void updateGrade(Grade grade, String username) {
		departmentDao.notExistObject(Department.class, grade.getDepartment().getDepartmentId());
		gradeDao.updateObject(grade);
		saveLog(username, "修改系别：" + grade.getGradeId());
	}

	public void deleteGrade(List<Serializable> ids, String username) {
		gradeDao.deleteObjects(Grade.class, ids);
		saveLog(username, "删除系别：" + ids);
	}

	public Grade findGrade(String id) {
		return gradeDao.findObject(Grade.class, id);
	}

	public Pagination<Grade> findGrades(Map<String, Object> map,
			int pageNum, int pageSize) {
		return gradeDao.findObjects(Grade.class, map, pageNum,
				pageSize);
	}

	public void setGradeDao(ObjectDao<Grade> gradeDao) {
		this.gradeDao = gradeDao;
	}

	public void setDepartmentDao(ObjectDao<Department> departmentDao) {
		this.departmentDao = departmentDao;
	}
}
