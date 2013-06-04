package com.jdbc.pool.proxy.way1;

import java.sql.DriverManager;
import java.util.LinkedList;

public class DataSource {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static LinkedList<java.sql.Connection> pool = new LinkedList<java.sql.Connection>();
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

	public static void decrease() {
		currentConn--;
	}

	private static void createConn() {
		try {
			java.sql.Connection conn = DriverManager.getConnection(URL, USER,
					PASSWORD);
			pool.addLast(new Connection(conn));
			currentConn++;
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static java.sql.Connection getConnection() {
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

	public static void close(java.sql.Connection conn) {
		try {
			if (null != conn) {
				pool.addLast(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 14; i++) {
			System.out.println(getConnection());
		}
	}
}
