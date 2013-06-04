package com.jvwl.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.jvwl.bean.Pagination;
import com.jvwl.model.Log;

public interface LogService {

	public void deleteLogs(List<Serializable> ids);

	public Pagination<Log> findLogs(Map<String, Object> map, int pageNum, int pageSize);

}