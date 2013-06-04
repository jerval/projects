package com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) {
		operate();
	}

	public static void operate() {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String sql = "insert into student(name) values('name1')";
			stmt.executeUpdate(sql);
			sql = "insert into student(name) values('name2')";
			stmt.executeUpdate(sql);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
			throw new RuntimeException(e.getMessage(), e);
		}finally{
			JDBCUtils.close(null, stmt, conn);
		}
	}
}
