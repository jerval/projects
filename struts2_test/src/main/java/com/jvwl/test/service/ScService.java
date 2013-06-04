package com.jvwl.test.service;

import java.sql.SQLException;

import com.jvwl.test.dao.ScDao;
import com.jvwl.test.dto.PageInfo;
import com.jvwl.test.dto.Pagination;
import com.jvwl.test.dto.ScDto;
import com.jvwl.test.model.Sc;

public class ScService {
	private ScDao scDao = new ScDao();

	public void add(Sc sc) throws SQLException {
		scDao.add(sc);
	}

	public void update(Sc sc) throws SQLException {
		scDao.update(sc);
	}

	public void delete(int id) throws SQLException {
		scDao.delete(id);
	}

	public Sc findScById(int id) throws SQLException {
		return scDao.findScById(id);
	}

	public Pagination<Sc> findScs(ScDto scDto, PageInfo pageInfo)
			throws SQLException {
		return scDao.findScs(scDto, pageInfo);
	}
}
