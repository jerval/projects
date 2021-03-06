package com.jvwl.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.jvwl.bean.Pagination;
import com.jvwl.dao.ObjectDao;
import com.jvwl.model.Log;
import com.jvwl.service.LogService;

public class LogServiceImpl implements LogService {
	private ObjectDao<Log> logDao;

	public void setLogDao(ObjectDao<Log> logDao) {
		this.logDao = logDao;
	}

	public void deleteLogs(List<Serializable> ids) {
		logDao.deleteObjects(Log.class, ids);
	}

	public Pagination<Log> findLogs(Map<String, Object> map,
			int pageNum, int pageSize) {
		return logDao.findObjects(Log.class, map, pageNum,
				pageSize);
	}
}
