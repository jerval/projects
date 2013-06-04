package com.jvwl.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.jvwl.test.db.DBManager;
import com.jvwl.test.dto.PageInfo;
import com.jvwl.test.dto.Pagination;
import com.jvwl.test.dto.ScDto;
import com.jvwl.test.model.Sc;

public class ScDao {
	public void add(Sc sc) throws SQLException {
		String sql = "insert into t_sc(id,s_id,c_id,sc_score,sc_memo) values(?,?,?,?,?)";
		Object[] params = new Object[] { sc.getId(), sc.getS_id(),
				sc.getC_id(),sc.getSc_score(),
				sc.getSc_memo() };
		DBManager.update(sql, params);
	}

	public void update(Sc sc) throws SQLException {
		String sql = "update t_sc set s_id=?,c_id=?,sc_score=?,sc_memo=? where id=?";
		Object[] params = new Object[] {sc.getS_id(),
				sc.getC_id(),sc.getSc_score(),sc.getSc_memo(), sc.getId() };
		DBManager.update(sql, params);
	}

	public void delete(int id) throws SQLException {
		String sql = "delete from t_sc where id=?";
		DBManager.update(sql, id);
	}

	@SuppressWarnings("unchecked")
	public Sc findScById(int id) throws SQLException {
		String sql = "select * from t_sc where id=?";
		List list = (List) DBManager.query(sql, Sc.class, id);
		if (list != null && list.size() > 0) {
			return (Sc) list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Pagination<Sc> findScs(ScDto scDto, PageInfo pageInfo)
			throws SQLException {
		String sqlWhere = handlerSQL(scDto);
		String sqlCount = "select count(*) from t_sc where 1=1" + sqlWhere;
		long maxElements = DBManager.queryCount(sqlCount);
		String sql = "select * from t_sc where 1=1" + sqlWhere;
		List list = (List) DBManager.query(sql, Sc.class);
		if (maxElements > 0) {
			Pagination<Sc> pagination = new Pagination<Sc>(list,
					maxElements, pageInfo.getPageNo(), pageInfo.getPageSize());
			return pagination;
		}
		return null;
	}

	private String handlerSQL(ScDto scDto) {
		if (scDto != null) {
			StringBuffer sqlWhere = new StringBuffer();
			if (scDto.getId() != null) {
				sqlWhere.append(" and id=").append(scDto.getId());
			}
			if (scDto.getS_id() != null && !"".equals(scDto.getS_id())) {
				sqlWhere.append(" and s_id='").append(scDto.getS_id())
						.append("'");
			}
			if (scDto.getC_id() != null
					&& !"".equals(scDto.getC_id())) {
				sqlWhere.append(" and c_id='")
						.append(scDto.getC_id()).append("'");
			}
			if(scDto.getScore1()!=null&&scDto.getScore2()!=null){
				sqlWhere.append(" and sc_score between ").append(scDto.getScore1())
				.append(" and ").append(scDto.getScore2());		
			}else if(scDto.getScore1()!=null){
				sqlWhere.append(" and sc_score >= ").append(scDto.getScore1());
			}else if(scDto.getScore2()!=null){
				sqlWhere.append(" and sc_score <= ").append(scDto.getScore2());
			}
			return sqlWhere.toString();
		}
		return "";
	}
}
