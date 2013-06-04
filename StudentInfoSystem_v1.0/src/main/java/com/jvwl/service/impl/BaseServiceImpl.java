package com.jvwl.service.impl;

import java.util.Date;

import com.jvwl.dao.ObjectDao;
import com.jvwl.model.Log;
import com.jvwl.service.BaseService;

public class BaseServiceImpl implements BaseService {
	protected ObjectDao<Log> logDao;

	public void setLogDao(ObjectDao<Log> logDao) {
		this.logDao = logDao;
	}

	public void saveLog(String username, String content) {
		Log log = new Log();
		log.setUsername(username);
		log.setTime(new Date());
		log.setContent(content);
		logDao.addObject(log);
	}
}
