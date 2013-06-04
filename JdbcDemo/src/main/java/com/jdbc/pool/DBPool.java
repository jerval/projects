package com.jdbc.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class DBPool {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	
	private static int initConn = 5;
	private static int maxConn = 10;
	private static int currentConn = 0;

	static {
		try {
			Class.forName(DRIVER);
			initPool();
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	private static void initPool() {
		for (int i = 0; i < initConn; i++) {
			createConn();
		}
	}

	private static void createConn() {
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pool.addLast(conn);
			currentConn++;
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() {
		synchronized (pool) {
			if (pool.size() > 0) {
				return pool.removeFirst();
			}
			if (currentConn < maxConn) {
				createConn();
				return pool.removeFirst();
			}
			throw new RuntimeException("没有可用的链接！");
		}
	}

	public static void close(ResultSet rs, Statement stmt, Connection conn) {
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
						pool.addLast(conn);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String a[] = new String[4];
		for(int i=0;i<12;i++){
			System.out.println(getConnection());
		}
	}
}
