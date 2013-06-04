package com.jdbc.general.dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jdbc.JDBCUtils;
import com.jdbc.exception.BusinessException;

public class SuperDao {

	protected Object insert(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement ps = null;
		Object key = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			if (null != params) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				key = rs.getObject(0);
			}
			return key;
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(), e);
		} finally {
			JDBCUtils.close(null, ps, conn);
		}
	}

	protected int update(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = -1;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			if (null != params) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			n = ps.executeUpdate();
			return n;
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(), e);
		} finally {
			JDBCUtils.close(null, ps, conn);
		}
	}

	protected Object find(String sql, Object[] params,RowMapper mapper) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Object obj = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			if (null != params) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			rs = ps.executeQuery();
			obj = mapper.rowMapper(rs);
			return obj;
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(), e);
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
	}
}
