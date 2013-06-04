package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

/**
 * 
 * @author Jerval
 * 
 * @date 2011-5-17
 */
public class DateDemo {

	public static void main(String[] args) throws SQLException {
		// create("testname", new Date());
		read(9);
	}

	private static void create(String name, Date birthday) throws SQLException {
		// get connection
		Connection conn = JDBCUtilsSingleton.getInstance().getConnection();
		// create statement
		PreparedStatement ps = conn
				.prepareStatement("insert into student(name,birthday) values(?,?)");
		// execute query
		ps.setString(1, name);
		ps.setTimestamp(2, new java.sql.Timestamp(birthday.getTime()));
		// ps.setDate(2, new java.sql.Date(birthday.getTime()));
		int i = ps.executeUpdate();
		System.out.println(i);
		JDBCUtilsSingleton.getInstance().close(null, ps, conn);
	}

	private static void read(int id) throws SQLException {
		// get connection
		Connection conn = JDBCUtilsSingleton.getInstance().getConnection();
		// create statement
		PreparedStatement ps = conn
				.prepareStatement("select birthday from student where id=?");
		// execute query
		ps.setInt(1, id);
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
