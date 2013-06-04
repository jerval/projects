package com.jvwl.test.dao;

import java.sql.SQLException;
import java.util.List;
import com.jvwl.test.db.DBManager;
import com.jvwl.test.dto.PageInfo;
import com.jvwl.test.dto.Pagination;
import com.jvwl.test.dto.StudentDto;
import com.jvwl.test.model.Student;
import com.jvwl.test.util.TimeUtil;

public class StudentDao {
	public void add(Student student) throws SQLException {
		String sql = "insert into t_student(id,s_id,s_name,s_sex,s_birthday,s_memo) values(?,?,?,?,?,?)";
		Object[] params = new Object[] { student.getId(), student.getS_id(),
				student.getS_name(), student.getS_sex()?1:0,
				student.getS_birthday(), student.getS_memo() };
		DBManager.update(sql, params);
	}

	public void update(Student student) throws SQLException {
		String sql = "update t_student set s_id=?,s_name=?,s_sex=?,s_birthday=?,s_memo=? where id=?";
		Object[] params = new Object[] { student.getS_id(),
				student.getS_name(), student.getS_sex()?1:0,
				student.getS_birthday(), student.getS_memo(), student.getId() };
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
	public Student findStudentByS_id(String s_id) throws SQLException {
		String sql = "select * from t_student where s_id=?";
		List list = (List) DBManager.query(sql, Student.class, s_id);
		if (list != null && list.size() > 0) {
			return (Student) list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Pagination<Student> findStudents(StudentDto studentDTO,
			PageInfo pageInfo) throws SQLException {
		String sqlWhere = handlerSQL(studentDTO);
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

	String handlerSQL(StudentDto studentDto) {
		if (studentDto != null) {
			StringBuffer sqlWhere = new StringBuffer();
			if (studentDto.getId() != null) {
				sqlWhere.append(" and id=").append(studentDto.getId());
			}
			if (studentDto.getS_id() != null
					&& !"".equals(studentDto.getS_id())) {
				sqlWhere.append(" and s_id='").append(studentDto.getS_id())
						.append("'");
			}
			if (studentDto.getS_name() != null
					&& !"".equals(studentDto.getS_name())) {
				sqlWhere.append(" and s_name='").append(studentDto.getS_name())
						.append("'");
			}
			if (studentDto.getS_sex() != null) {
				sqlWhere.append(" and s_sex=").append(studentDto.getS_sex());
			}
			if (studentDto.getS_birthday() != null
					&& studentDto.getS_birthday2() != null) {
				sqlWhere.append(" and s_birthday between '").append(
						TimeUtil.getDate(studentDto.getS_birthday())).append(
						"' and '").append(
						TimeUtil.getDate(studentDto.getS_birthday2())).append(
						"'");
			} else if (studentDto.getS_birthday() != null) {
				sqlWhere.append(" and s_birthday >= '").append(
						TimeUtil.getDate(studentDto.getS_birthday())).append(
						"'");
			} else if (studentDto.getS_birthday2() != null) {
				sqlWhere.append(" and s_birthday <= '").append(
						TimeUtil.getDate(studentDto.getS_birthday())).append(
						"'");
			}

			return sqlWhere.toString();
		}
		return "";
	}
}
