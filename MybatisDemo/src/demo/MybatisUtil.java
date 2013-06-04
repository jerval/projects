package com.mybatis.demo;

import java.io.IOException;
import java.io.Reader;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class MybatisUtil {

	public static void main(String[] args) {

	}

	public static SqlSessionFactory getSqlSessionFactoryByXml() {
		String resource = "com/mybatis/demo1/MapperConfig.xml";
		SqlSessionFactory sessionFactory = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

	public static SqlSessionFactory getSqlSessionFactoryNoXml() {
		DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development",
				transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(BlogMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(configuration);
		// ... or ...
		SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader,
				props);
		// ... or ...
		SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader,
				environment, props);
		SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader,
				environment);
		SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader,
				environment, properties);
		// 如果环境被忽略，那么默认环境将会被加载，如下进行：
		SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader);
		SqlSessionFactory factory = sqlSessionFactoryBuilder.build(reader,
				properties);

		return null;
	}

	public static SqlSessionFactory getSqlSessionFactoryNoXml2() {
		DataSource dataSource = BaseDataTest.createBlogDataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development",
				transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.setLazyLoadingEnabled(true);
		configuration.setEnhancementEnabled(true);
		configuration.getTypeAliasRegistry().registerAlias(Blog.class);
		configuration.getTypeAliasRegistry().registerAlias(Post.class);
		configuration.getTypeAliasRegistry().registerAlias(Author.class);
		configuration.addMapper(BoundBlogMapper.class);
		configuration.addMapper(BoundAuthorMapper.class);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configuration);
	}

	public static SqlSession getSqlSessionWay1(SqlSessionFactory factory) {
		SqlSession session = factory.openSession();
		try {
			Blog blog = (Blog) session.selectOne(
					"org.mybatis.example.BlogMapper.selectBlog", 101);
		} finally {
			session.close();
		}
	}

	public static SqlSession getSqlSessionWay2(SqlSessionFactory factory) {
		SqlSession session = factory.openSession();
		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			Blog blog = mapper.selectBlog(101);
		} finally {
			session.close();
		}
	}
}
