package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Jerval
 * 
 * @date 2011-5-14
 */
public class SQLInject {

	public static void main(String[] args) throws SQLException {
//		readByStatement("admin");
//		readByStatement("' or 1 or '");
		readByPrepareStatement("admin");
//		readByPrepareStatement("' or 1 or '");
	}

	private static void readByStatement(String name) throws SQLException {
		// get connection
		Connection conn = JDBCUtilsSingleton.getInstance().getConnection();
		// create statement
		Statement stmt = conn.createStatement();
		// execute query
		ResultSet rs = stmt.executeQuery("select * from student where name='"
				+ name + "'");
		// get table meta data
		ResultSetMetaData metaData = rs.getMetaData();
		// get column count
		int num = metaData.getColumnCount();
		// iterate column name
		for (int i = 1; i <= num; i++) {
			System.out.print("[" + metaData.getColumnName(i) + "]");
		}
		System.out.println();
		for (int i = 1; i <= num; i++) {
			System.out.print("[" + metaData.getColumnTypeName(i) + "]");
		}
		System.out.println();
		while (rs.next()) {
			for (int i = 1; i <= num; i++) {
				System.out.print(rs.getString(metaData.getColumnName(i)));
			}
			System.out.println();
		}
		JDBCUtilsSingleton.getInstance().close(rs, stmt, conn);
	}
	private static void readByPrepareStatement(String name) throws SQLException {
		// get connection
		Connection conn = JDBCUtilsSingleton.getInstance().getConnection();
		// create statement
		String sql = "select * from student where name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		// execute query
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		// get table meta data
		ResultSetMetaData metaData = rs.getMetaData();
		// get column count
		int num = metaData.getColumnCount();
		// iterate column name
		for (int i = 1; i <= num; i++) {
			System.out.print("[" + metaData.getColumnName(i) + "]");
		}
		System.out.println();
		for (int i = 1; i <= num; i++) {
			System.out.print("[" + metaData.getColumnTypeName(i) + "]");
		}
		System.out.println();
		while (rs.next()) {
			for (int i = 1; i <= num; i++) {
				System.out.print(rs.getString(metaData.getColumnName(i)));
			}
			System.out.println();
		}
		JDBCUtilsSingleton.getInstance().close(rs, ps, conn);
	}
}
