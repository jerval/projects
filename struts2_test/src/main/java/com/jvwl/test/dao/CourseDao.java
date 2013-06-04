package com.jvwl.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.jvwl.test.db.DBManager;
import com.jvwl.test.dto.CourseDto;
import com.jvwl.test.dto.PageInfo;
import com.jvwl.test.dto.Pagination;
import com.jvwl.test.model.Course;

public class CourseDao {
	public void add(Course course) throws SQLException {
		String sql = "insert into t_course(id,c_id,c_name,c_memo) values(?,?,?,?)";
		Object[] params = new Object[] { course.getId(), course.getC_id(),
				course.getC_name(), course.getC_memo() };
		DBManager.update(sql, params);
	}

	public void update(Course course) throws SQLException {
		String sql = "update t_course set c_id=?,c_name=?,c_memo=? where id=?";
		Object[] params = new Object[] { course.getC_id(), course.getC_name(),
				course.getC_memo(), course.getId() };
		DBManager.update(sql, params);
	}

	public void delete(int id) throws SQLException {
		String sql = "delete from t_course where id=?";
		DBManager.update(sql, id);
	}

	@SuppressWarnings("unchecked")
	public Course findCourseById(int id) throws SQLException {
		String sql = "select * from t_course where id=?";
		List list = (List) DBManager.query(sql, Course.class, id);
		if (list != null && list.size() > 0) {
			return (Course) list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Course findCourseByC_id(String c_id) throws SQLException {
		String sql = "select * from t_course where c_id=?";
		List list = (List) DBManager.query(sql, Course.class, c_id);
		if (list != null && list.size() > 0) {
			return (Course) list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Pagination<Course> findCourses(CourseDto courseDTO, PageInfo pageInfo)
			throws SQLException {
		String sqlWhere = handlerSQL(courseDTO);
		String sqlCount = "select count(*) from t_course where 1=1" + sqlWhere;
		long maxElements = DBManager.queryCount(sqlCount);
		String sql = "select * from t_course where 1=1" + sqlWhere;
		List list = (List) DBManager.query(sql, Course.class);
		if (maxElements > 0) {
			Pagination<Course> pagination = new Pagination<Course>(list,
					maxElements, pageInfo.getPageNo(), pageInfo.getPageSize());
			return pagination;
		}
		return null;
	}

	private String handlerSQL(CourseDto courseDto) {
		if (courseDto != null) {
			StringBuffer sqlWhere = new StringBuffer();
			if (courseDto.getId() != null) {
				sqlWhere.append(" and id=").append(courseDto.getId());
			}
			if (courseDto.getC_id() != null && !"".equals(courseDto.getC_id())) {
				sqlWhere.append(" and c_id='").append(courseDto.getC_id())
						.append("'");
			}
			if (courseDto.getC_name() != null
					&& !"".equals(courseDto.getC_name())) {
				sqlWhere.append(" and c_name='").append(courseDto.getC_name())
						.append("'");
			}
			return sqlWhere.toString();
		}
		return "";
	}
}
