package com.jdbc.general.dao2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.domain.User;

public class UserDao {
	private SuperDao superDao = new SuperDao();

	public Integer add(final User user) {
		String sql = "insert into tbuser(username,password,age,regDate) values(?,?,?,?)";
		Object[] params = new Object[] { user.getUsername(),
				user.getPassword(), user.getAge(),
				new Timestamp(user.getRegDate().getTime()) };
		return (Integer) superDao.insert(sql, params);
	}

	public Integer update(final User user) {
		String sql = "update tbuser set username=?,password=?,age=?,regDate=? where id=?";
		Object[] params = new Object[] { user.getUsername(),
				user.getPassword(), user.getAge(),
				new Timestamp(user.getRegDate().getTime()), user.getId() };
		return superDao.update(sql, params);
	}

	public Integer delete(final User user) {
		String sql = "delete from tbuser where id=?";
		Object[] params = new Object[] { user.getId() };
		return superDao.update(sql, params);
	}

	public User findUserById(final Integer id) {
		String sql = "select username,age,regDate from tbuser where id=?";
		Object[] params = new Object[] { id };
		RowMapper mapper = new RowMapper() {

			@Override
			public Object rowMapper(ResultSet rs) throws SQLException {
				User user = null;
				if (rs.next()) {
					user = new User(id, rs.getString("username"),
							rs.getInt("age"), rs.getDate("regDate"));
				}
				return user;
			}
		};
		User user = (User) superDao.find(sql, params, mapper);
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> findUserAll(final int pageNo, final int pageSize) {
		String sql = "select id,username,age,regDate from tbuser limit ?,?";
		Object[] params = new Object[] { (pageNo - 1) * pageSize, pageSize };
		RowMapper mapper = new RowMapper() {

			@Override
			public Object rowMapper(ResultSet rs) throws SQLException {
				List<User> users = new ArrayList<User>();
				while (rs.next()) {
					users.add(new User(rs.getInt("id"), rs
							.getString("username"), rs.getInt("age"), rs
							.getDate("regDate")));
				}
				return users;
			}
		};
		return (List<User>) superDao.find(sql, params, mapper);
	}

}
