package com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePointDemo {

	public static void main(String[] args) {
		operate();
	}

	public static void operate() {
		Connection conn = null;
		Statement stmt = null;
		Savepoint point = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String sql = "insert into tbuser(username) values('name1 point')";
			stmt.executeUpdate(sql);
			point = conn.setSavepoint("point1");
			sql = "insert into tbuser(username) values('name2 point')";
			stmt.executeUpdate(sql);
			int a = 1;
			if (a == 1) {
				throw new RuntimeException("------------");
			}
			conn.commit();
		} catch (RuntimeException e) {
			try {
				if (null != conn && null != point) {
					conn.rollback(point);
					conn.commit();
				}
			} catch (SQLException e1) {
			}
			throw new RuntimeException(e.getMessage(), e);
		} catch (SQLException e) {
			try {
				if (null != conn) {
					conn.rollback();
				}
			} catch (SQLException e1) {
			}
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.close(null, stmt, conn);
		}
	}
}
