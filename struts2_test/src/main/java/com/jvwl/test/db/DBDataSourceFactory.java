package com.jvwl.test.db;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBDataSourceFactory {
	private static DataSource dataSource;
	static {
		initDataSourceByProperties();
		// initDataSourceByXML();
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static void initDataSourceByProperties() {
		// 读取属性文件方式保存的配置文件
		String path = Thread.currentThread().getContextClassLoader().getResource("dataSource.properties").getPath();
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("读取数据库配置文件dataSource.properties出错！");
			e.printStackTrace();
		}
		try {
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void initDataSourceByXML() {
		// 读取XML文件方式保存的配置文件
		String path = Thread.currentThread().getContextClassLoader().getResource("dataSource.xml").getPath();
		System.out.println(path);
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
	}
}
