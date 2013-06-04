package com.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetaDataDemo {

	public static void main(String[] args) {
		// getDBMetaData();
		// String sql = "select * from tbuser where id > ? and username like ?";
		// Object[] params = { 4, "user%" };
		// getParameterMetaData(sql, params);
		
		//System.out.println(getUserMapById(5));
		System.out.println(getUserMapBySQL("select * from tbuser where id>?",new Object[]{5}));
	}

	public static void getDBMetaData() {
		Connection conn = JDBCUtils.getConnection();
		try {
			DatabaseMetaData metaData = conn.getMetaData();
			System.out.println("getDatabaseProductName:"
					+ metaData.getDatabaseProductName());
			System.out.println("getDatabaseProductVersion:"
					+ metaData.getDatabaseProductVersion());
			System.out.println("getDriverName:" + metaData.getDriverName());
			System.out.println("getDriverVersion:"
					+ metaData.getDriverVersion());
			System.out.println("supportsTransactions:"
					+ metaData.supportsTransactions());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void getParameterMetaData(String sql, Object[] params) {
		Connection conn = JDBCUtils.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ParameterMetaData pmd = ps.getParameterMetaData();
			int count = pmd.getParameterCount();
			for (int i = 0; i < count; i++) {
				ps.setObject(i + 1, params[i]);
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t"
						+ rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Map<String, Object> getUserMapById(Integer id) {
		Connection conn = JDBCUtils.getConnection();
		String sql = "select * from tbuser where id=?";
		Map<String, Object> map = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				map = new HashMap<String, Object>();
				ResultSetMetaData rsmd = rs.getMetaData();
				int colNum = rsmd.getColumnCount();
				for (int i = 1; i <= colNum; i++) {
					String colName = rsmd.getColumnLabel(i);
					map.put(colName, rs.getObject(colName));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static List<Map<String, Object>> getUserMapBySQL(String sql,
			Object[] params) {
		Connection conn = JDBCUtils.getConnection();
		List<Map<String, Object>> list = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			if (null != params) {
				int len = params.length;
				for (int i = 0; i < len; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				ResultSetMetaData rsmd = rs.getMetaData();
				int colNum = rsmd.getColumnCount();
				for (int i = 1; i <= colNum; i++) {
					String colName = rsmd.getColumnLabel(i);
					map.put(colName, rs.getObject(colName));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
