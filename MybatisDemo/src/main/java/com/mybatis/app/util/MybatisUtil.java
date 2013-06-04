package com.mybatis.app.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	public static SqlSessionFactory sessionFactory;

	static {
		sessionFactory = getSqlSessionFactory();
	}

	private static SqlSessionFactory getSqlSessionFactory() {
		String resource = "MapperConfig.xml";
		SqlSessionFactory sessionFactory = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

	public static SqlSession getSqlSession() {
		return sessionFactory.openSession();
	}
}
