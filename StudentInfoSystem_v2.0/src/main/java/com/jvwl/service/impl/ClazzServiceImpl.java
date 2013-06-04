package com.jvwl.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jvwl.bean.Pagination;
import com.jvwl.dao.ObjectDao;
import com.jvwl.model.Clazz;
import com.jvwl.model.Grade;
import com.jvwl.service.ClazzService;

@Component("clazzService")
public class ClazzServiceImpl extends BaseServiceImpl implements ClazzService{
	private ObjectDao<Clazz> clazzDao;
	private ObjectDao<Grade> gradeDao;

	@Resource(name="objectDao")
	public void setClazzDao(ObjectDao<Clazz> clazzDao) {
		this.clazzDao = clazzDao;
	}
	@Resource(name="objectDao")
	public void setGradeDao(ObjectDao<Grade> gradeDao) {
		this.gradeDao = gradeDao;
	}

	public void addClazz(Clazz clazz, String username) {
		gradeDao.notExistObject(Grade.class, clazz.getGrade().getGradeId());
		clazzDao.existObject(Clazz.class, clazz.getClassId());
		clazzDao.addObject(clazz);
		saveLog(username, "添加班级：" + clazz.getClassId());
	}

	public void updateClazz(Clazz clazz, String username) {
		gradeDao.notExistObject(Grade.class, clazz.getGrade().getGradeId());
		clazzDao.updateObject(clazz);
		saveLog(username, "修改班级：" + clazz.getClassId());
	}

	public void deleteClazz(List<Serializable> ids, String username) {
		clazzDao.deleteObjects(Clazz.class, ids);
		saveLog(username, "删除班级：" + ids);
	}

	public Clazz findClazz(String id) {
		return clazzDao.findObject(Clazz.class, id);
	}

	public Pagination<Clazz> findClazzs(Map<String, Object> map,
			int pageNum, int pageSize) {
		return clazzDao.findObjects(Clazz.class, map, pageNum,
				pageSize);
	}
}
