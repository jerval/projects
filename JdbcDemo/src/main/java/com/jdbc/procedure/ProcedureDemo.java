package com.jdbc.procedure;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Date;

import com.jdbc.domain.User;
import com.jdbc.factory.IConnection;
import com.jdbc.factory.Templete;

/**
 * 通过存储过程拿到新添加数据ID，通过数据库自身函数取得，数据库关联性强，代码移植性差
 * 
 * @author Jerval
 * 
 * @date 2011-6-7
 */
public class ProcedureDemo {

	public static void main(String[] args) {
		int id = (Integer) addUser(new User("username ", "12344", 12,
				new Date()));
		System.out.println(id);
	}

	public static Serializable addUser(final User user) {
		return Templete.callback(new IConnection() {

			@Override
			public <T> T doThing(Connection conn, Class<T> clazz)
					throws Exception {
				String sql = "{ call addUser(?,?,?,?,?) } ";
				CallableStatement cs = conn.prepareCall(sql);
				cs.registerOutParameter(5, Types.INTEGER);
				cs.setString(1, user.getUsername());
				cs.setString(2, user.getPassword());
				cs.setInt(3, user.getAge());
				cs.setDate(4, new java.sql.Date(user.getRegDate().getTime()));
				cs.executeUpdate();
				Integer id = cs.getInt(5);
				return (T)id;
			}
		}, Integer.class);
	}
}
