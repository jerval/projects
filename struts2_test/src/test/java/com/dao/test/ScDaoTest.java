package com.dao.test;

import java.sql.SQLException;

import org.junit.Test;

import com.jvwl.test.dao.ScDao;
import com.jvwl.test.dto.PageInfo;
import com.jvwl.test.dto.Pagination;
import com.jvwl.test.dto.ScDto;
import com.jvwl.test.model.Sc;

public class ScDaoTest {

	ScDao scDao = new ScDao();

	@Test
	public void testAdd() throws SQLException {
		Sc sc = new Sc();
		sc.setC_id("2001");
		sc.setS_id("10011");
		sc.setSc_memo("adf");
		scDao.add(sc);
		sc.setC_id("2003");
		sc.setS_id("10013");
		sc.setSc_memo("adfdfd");
		scDao.add(sc);
	}

	@Test
	public void testUpdate() throws SQLException {
		Sc sc = new Sc();
		sc.setId(1);
		sc.setC_id("2003");
		sc.setS_id("10013");
		sc.setSc_memo("adfdfd");
		scDao.update(sc);
	}

	@Test
	public void testDelete() throws SQLException {
		scDao.delete(1);
	}

	@Test
	public void testFindScById() throws SQLException {
		System.out.println(scDao.findScById(2));
	}

	@Test
	public void testFindScs() throws SQLException {
		ScDto scDto = new ScDto();
		scDto.setC_id("2001");
		PageInfo pageInfo = new PageInfo(1, 10);
		Pagination<Sc> pagination = scDao.findScs(scDto, pageInfo);
		System.out.println(pagination);
		System.out.println(pagination.getList());
	}

}
