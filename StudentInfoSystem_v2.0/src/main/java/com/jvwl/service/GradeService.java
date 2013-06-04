package com.jvwl.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.jvwl.bean.Pagination;
import com.jvwl.model.Grade;

public interface GradeService {

	public void addGrade(Grade grade, String username);

	public void updateGrade(Grade grade, String username);

	public void deleteGrade(List<Serializable> ids, String username);

	public Grade findGrade(String id);

	public Pagination<Grade> findGrades(Map<String, Object> map, int pageNum,
			int pageSize);

}