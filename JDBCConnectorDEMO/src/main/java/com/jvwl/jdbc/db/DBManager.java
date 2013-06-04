package com.jvwl.jdbc.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

public class DBManager {
	private static QueryRunner qr;

	static {
		qr = new QueryRunner(DBDataSourceFactory.getDataSource());
	}

	@SuppressWarnings("unchecked")
	public static long queryCount(String sql) throws SQLException{
		Map countMap = (Map)qr.query(sql, new MapHandler());
		if(countMap!=null&&countMap.size()>0){
			return (Long)countMap.values().iterator().next();
		}
		return 0l;
	}
	@SuppressWarnings("unchecked")
	public static List query(String sql, Class type) throws SQLException {
		ResultSetHandler rsh = new BeanListHandler(type);
		return (List) qr.query(sql, rsh);
	}

	@SuppressWarnings("unchecked")
	public static List query(String sql, Class type, Object param)
			throws SQLException {
		ResultSetHandler rsh = new BeanListHandler(type);
		return (List) qr.query(sql, rsh, new Object[] { param });
	}

	@SuppressWarnings("unchecked")
	public static List query(String sql, Class type, Object[] params)
			throws SQLException {
		ResultSetHandler rsh = new BeanListHandler(type);
		return (List) qr.query(sql, rsh, params);
	}

	public static int update(String sql) throws SQLException {
		return qr.update(sql);
	}

	public static int update(String sql, Object param) throws SQLException {
		return qr.update(sql, param);
	}

	public static int update(String sql, Object[] params) throws SQLException {
		return qr.update(sql, params);
	}

	public static int[] batch(String sql, Object[][] params)
			throws SQLException {
		return qr.batch(sql, params);
	}

	public static void fillStatement(PreparedStatement stmt, Object[] params)
			throws SQLException {
		qr.fillStatement(stmt, params);
	}

	public static DataSource getDataSource() {
		return qr.getDataSource();
	}
	
}
