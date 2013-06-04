package com.jdbc.procedure;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import com.jdbc.domain.User;
import com.jdbc.factory.IConnection;
import com.jdbc.factory.Templete;

/**
 * 通过数据库驱动实现拿到新添加数据ID，通过sql Api，数据库关联性弱，代码移植性好
 * 
 * @author Jerval
 *
 * @date 2011-6-7
 */
public class ReturnIdDemo {

	public static void main(String[] args) {
		int id = (Integer) addUser(new User("uuu ", "12344", 12, new Date()));
		System.out.println(id);
	}

	public static Serializable addUser(final User user) {
		return  Templete.callback(new IConnection() {
			
			@Override
			public <T> T doThing(Connection conn, Class<T> clazz) throws Exception {
				String sql = "insert into tbuser(username,password,age,regDate) values(?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setInt(3, user.getAge());
				ps.setDate(4, new java.sql.Date(user.getRegDate().getTime()));
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				Integer id = null;
				if(rs.next()){
					id = rs.getInt(1);
				}
				return (T)id;
			}
		}, Integer.class);
	}
}
