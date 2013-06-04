package com.mybatis.app.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.app.mapper.StudentMapper;
import com.mybatis.app.model.Student;
import com.mybatis.app.util.MybatisUtil;
import com.mybatis.app.util.Page;

public class StudentService {

	public void add(Student student) {
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			mapper.add(student);
			session.commit();// 这里一定要提交，不然数据进不去数据库中
		} finally {
			session.close();
		}
	}

	public void update(Student student) {
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			mapper.update(student);
			session.commit();// 这里一定要提交，不然数据进不去数据库中
		} finally {
			session.close();
		}
	}

	public void delete(Integer id) {
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			mapper.delete(id);
			session.commit();// 这里一定要提交，不然数据进不去数据库中
		} finally {
			session.close();
		}
	}

	public Student findById(Integer id) {
		Student student = null;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			student = mapper.findById(id);
		} finally {
			session.close();
		}
		return student;
	}

	public List<Student> findByPage(Integer pageNo, Integer pageSize) {
		List<Student> student =null;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			student =mapper.findByPage(new Page(pageNo, pageSize));
		} finally {
			session.close();
		}
		return student;
	}
	public List<String> findNamesByPage(Integer pageNo, Integer pageSize) {
		List<String> names =null;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			names =mapper.findNamesByPage(new Page(pageNo, pageSize));
		} finally {
			session.close();
		}
		return names;
	}
	public List<Map<String, Object>> findCommonByPage(Integer pageNo, Integer pageSize) {
		List<Map<String, Object>> results =null;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			results =mapper.findCommonByPage(new Page(pageNo, pageSize));
		} finally {
			session.close();
		}
		return results;
	}
	@SuppressWarnings("unchecked")
	public List<Object> findBySql(String sql,Object params) {
		List<Object> results =null;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			results =session.selectList(sql,params);
		} finally {
			session.close();
		}
		return results;
	}
}
