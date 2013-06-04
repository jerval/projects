package com.jvwl.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.jvwl.jdbc.db.DBManager;
import com.jvwl.jdbc.dto.PageInfo;
import com.jvwl.jdbc.dto.Pagination;
import com.jvwl.jdbc.model.Student;

public class StudentDAO {
	public void add(Student student) throws SQLException {
		String sql = "insert into t_student(id,stu_id,stu_name) values(?,?,?)";
		Object[] params = new Object[] { student.getId(), student.getStu_id(),
				student.getStu_name() };
		DBManager.update(sql, params);
	}

	public void update(Student student) throws SQLException {
		String sql = "update t_student set stu_id=?,stu_name=? where id=?";
		Object[] params = new Object[] { student.getStu_id(),
				student.getStu_name(), student.getId() };
		DBManager.update(sql, params);
	}

	public void delete(int id) throws SQLException {
		String sql = "delete from t_student where id=?";
		DBManager.update(sql, id);
	}

	@SuppressWarnings("unchecked")
	public Student findStudentById(int id) throws SQLException {
		String sql = "select * from t_student where id=?";
		List list = (List) DBManager.query(sql, Student.class, id);
		if (list != null && list.size() > 0) {
			return (Student) list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Student findStudentByStu_id(String stu_id) throws SQLException {
		String sql = "select * from t_student where stu_id=?";
		List list = (List) DBManager.query(sql, Student.class, stu_id);
		if (list != null && list.size() > 0) {
			return (Student) list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Pagination<Student> findStudents(Student student, PageInfo pageInfo)
			throws SQLException {
		String sqlWhere = handlerSQL(student);
		String sqlCount = "select count(*) from t_student where 1=1" + sqlWhere;
		long maxElements = DBManager.queryCount(sqlCount);
		String sql = "select * from t_student where 1=1" + sqlWhere;
		List list = (List) DBManager.query(sql, Student.class);
		if (maxElements > 0) {
			Pagination<Student> pagination = new Pagination<Student>(list,
					maxElements, pageInfo.getPageNo(), pageInfo.getPageSize());
			return pagination;
		}
		return null;
	}

	private String handlerSQL(Student student) {
		if (student != null) {
			StringBuffer sqlWhere = new StringBuffer();
			if (student.getId() != null) {
				sqlWhere.append(" and id=").append(student.getId());
			}
			if (student.getStu_id() != null && "".equals(student.getStu_id())) {
				sqlWhere.append(" and stu_id='").append(student.getStu_id())
						.append("'");
			}
			if (student.getStu_name() != null
					&& "".equals(student.getStu_name())) {
				sqlWhere.append(" and stu_name='")
						.append(student.getStu_name()).append("'");
			}
			return sqlWhere.toString();
		}
		return "";
	}
}
