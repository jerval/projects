package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * singleton mode
 * @author Jerval
 * 
 * @date 2011-5-12
 */
public class DBConnectionV3 {

	public static void main(String[] args) throws Exception {
		// get connection
		Connection conn = JDBCUtilsSingleton.getInstance().getConnection();
		// create statement
		Statement stmt = conn.createStatement();
		// execute query
		ResultSet rs = stmt.executeQuery("select * from student");
		//get table meta data
		ResultSetMetaData metaData = rs.getMetaData();
		//get column count
		int num = metaData.getColumnCount();
		//iterate column name
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

}
