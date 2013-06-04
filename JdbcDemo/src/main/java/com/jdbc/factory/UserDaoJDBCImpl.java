package com.jdbc.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.domain.User;

/**
 * 
 * @author Jerval
 * 
 * @date 2011-6-1
 */
public class UserDaoJDBCImpl implements IUserDao {

	@Override
	public void addUser(final User user) {
		Templete.callback(new IConnection() {

			@Override
			public <T> T doThing(Connection conn, Class<T> clazz)
					throws Exception {
				String sql = "insert into tbuser(username,password,age,regDate) values(?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setInt(3, user.getAge());
				ps.setTimestamp(4, new Timestamp(user.getRegDate().getTime()));
				ps.executeUpdate();
				ps.close();
				return null;
			}
		});
	}

	@Override
	public void updateUser(final User user) {
		Templete.callback(new IConnection() {

			@Override
			public <T> T doThing(Connection conn, Class<T> clazz)
					throws Exception {
				String sql = "update tbuser set username=?,password=?,age=?,regDate=? where id=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setInt(3, user.getAge());
				ps.setTimestamp(4, new Timestamp(user.getRegDate().getTime()));
				ps.setInt(5, user.getId());
				ps.executeUpdate();
				ps.close();
				return null;
			}
		});
	}

	@Override
	public void deleteUser(final User user) {
		Templete.callback(new IConnection() {

			@Override
			public <T> T doThing(Connection conn, Class<T> clazz)
					throws Exception {
				String sql = "delete from tbuser where id=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, user.getId());
				ps.executeUpdate();
				ps.close();
				return null;
			}
		});
	}

	@Override
	public User findUserById(final Integer id) {
		return Templete.callback(new IConnection() {

			@Override
			public <T> T doThing(Connection conn, Class<T> clazz)
					throws Exception {
				String sql = "select username,age,regDate from tbuser where id=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				User user = null;
				if (rs.next()) {
					user = new User(id, rs.getString("username"), rs
							.getInt("age"), rs.getDate("regDate"));
				}
				ps.close();
				return (T) user;
			}
		}, User.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUserAll(final int pageNo, final int pageSize) {
		return Templete.callback(new IConnection() {
			
			@Override
			public <T> T doThing(Connection conn, Class<T> clazz) throws Exception {
				String sql = "select id,username,age,regDate from tbuser limit ?,?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, (pageNo - 1) * pageSize);
				ps.setInt(2, pageSize);
				ResultSet rs = ps.executeQuery();
				List<User> list = new ArrayList<User>();
				while (rs.next()) {
					list.add(new User(rs.getInt("id"),
							rs.getString("username"), rs.getInt("age"), rs
									.getDate("regDate")));
				}
				ps.close();
				return (T)list;
			}
		}, List.class);
	}

}
