package com.jvwl.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.jvwl.bean.Pagination;
import com.jvwl.model.Clazz;

public interface ClazzService {

	public void addClazz(Clazz clazz, String username);

	public void updateClazz(Clazz clazz, String username);

	public void deleteClazz(List<Serializable> ids, String username);

	public Clazz findClazz(String id);

	public Pagination<Clazz> findClazzs(Map<String, Object> map, int pageNum,
			int pageSize);

}