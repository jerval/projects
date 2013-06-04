package com.jvwl.jdbc.db;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBDataSourceFactory {
	private static DataSource dataSource;
	static {
		// initDataSourceByProperties();
		initDataSourceByXML();
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static void initDataSourceByProperties() {
		// 读取属性文件方式保存的配置文件
		String path = Thread.currentThread().getContextClassLoader().getResource("dataSource.properties")
				.getPath();
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("读取数据库配置文件dataSource.properties出错！");
			e.printStackTrace();
		}
		// method1 通过BasicDataSourceFactory获得<
		try {
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// method1>

		// method2 通过直接创建BasicDataSource<
		/*
		 * BasicDataSource bds = new BasicDataSource();
		 * bds.setDriverClassName(prop.getProperty("driverClassName"));
		 * bds.setUrl(prop.getProperty("url"));
		 * bds.setUsername(prop.getProperty("username"));
		 * bds.setPassword(prop.getProperty("password"));
		 * bds.setInitialSize(Integer.parseInt(prop .getProperty("initialSize",
		 * "3")));
		 * bds.setMaxActive(Integer.parseInt(prop.getProperty("maxActive",
		 * "8"))); bds.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle",
		 * "8"))); bds.setMinIdle(Integer.parseInt(prop.getProperty("minIdle",
		 * "0"))); bds.setMaxWait(Long.parseLong(prop.getProperty("maxWait",
		 * "10")));
		 */
		// method2>

	}

	public static void initDataSourceByXML() {
		// 读取XML文件方式保存的配置文件
		// method1<
		String path = Thread.currentThread().getContextClassLoader().getResource("dataSource.xml").getPath();
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			prop.loadFromXML(fis);
		} catch (Exception e) {
			System.out.println("读取数据库配置文件dataSource.xml出错！");
			e.printStackTrace();
		}
		try {
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// method1>
		
		// method2<
		
		// method2>
	}
}
