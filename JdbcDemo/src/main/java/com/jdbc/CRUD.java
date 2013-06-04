package com.jdbc;

import java.sql.Connection;
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
public class CRUD {

	public static void main(String[] args) throws SQLException {
//		create();
//		read();
//		update();
		delete();
	}
	private static void create() throws SQLException{
		// get connection
		Connection conn = JDBCUtilsSingleton.getInstance().getConnection();
		// create statement
		Statement stmt = conn.createStatement();
		// execute query
		int i = stmt.executeUpdate("insert into student(name) values('admin')");
		System.out.println(i);
		JDBCUtilsSingleton.getInstance().close(null, stmt, conn);
	}

	private static void read() throws SQLException{
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
	private static void update() throws SQLException{
		// get connection
		Connection conn = JDBCUtilsSingleton.getInstance().getConnection();
		// create statement
		Statement stmt = conn.createStatement();
		// execute query
		int i = stmt.executeUpdate("update student set name='aaa' where id = 9");
		System.out.println(i);
		JDBCUtilsSingleton.getInstance().close(null, stmt, conn);
	}
	private static void delete() throws SQLException{
		// get connection
		Connection conn = JDBCUtilsSingleton.getInstance().getConnection();
		// create statement
		Statement stmt = conn.createStatement();
		// execute query
		int i = stmt.executeUpdate("delete from student where id=9");
		System.out.println(i);
		JDBCUtilsSingleton.getInstance().close(null, stmt, conn);
	}

}
