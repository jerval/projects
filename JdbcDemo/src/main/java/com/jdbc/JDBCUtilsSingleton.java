package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtilsSingleton {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static JDBCUtilsSingleton instance;

	private JDBCUtilsSingleton() {
	}

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static JDBCUtilsSingleton getInstance() {
		if (null == instance) {
			synchronized (JDBCUtilsSingleton.class) {
				if (null == instance) {
					instance = new JDBCUtilsSingleton();
				}
			}
		}
		return instance;
	}

	public Connection getConnection()  {
		Connection conn= null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return conn;
	}

	public void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (null != rs) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != stmt) {
					stmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (null != conn) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
