package com.jdbc;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.jdbc.domain.User;
import com.jdbc.factory.IConnection;
import com.jdbc.factory.Templete;

public class ReflectDemo {

	public static void main(String[] args) {
		User user = findById(4, User.class, "tbuser");
		System.out.println(user);
	}

	public static <T> T findById(final Serializable id, final Class<T> clazz,
			final String tbName) {
		return Templete.callback(new IConnection() {
			
			@Override
			public <T> T doThing(Connection conn, Class<T> clazz) throws Exception {
				StringBuilder sb = new StringBuilder();
				sb.append("select * from ").append(tbName)
						.append(" where id = ?");
				PreparedStatement ps = conn.prepareStatement(sb.toString());
				ps.setObject(1, id);
				ResultSet rs = ps.executeQuery();
				return toObject(rs, clazz);
			}
		},clazz);
	}

	public static <T> Set<T> findByPage(final Class<T> clazz,
			final String tbName) {
		return findByPage(clazz, tbName, null, null, null);
	}

	public static <T> Set<T> findByPage(final Class<T> clazz,
			final String tbName, final String sqlWhere) {
		return findByPage(clazz, tbName, null, null, sqlWhere);
	}

	public static <T> Set<T> findByPage(final Class<T> clazz,
			final String tbName, final Integer pageNo, final Integer pageSize) {
		return findByPage(clazz, tbName, pageNo, pageSize, null);
	}

	public static <T> Set<T> findByPage(final Class<T> clazz,
			final String tbName, final Integer pageNo, final Integer pageSize,
			final String sqlWhere) {
		final Set<T> set = new HashSet<T>();
		Templete.callback(new IConnection() {
			
			@Override
			public <T> T doThing(Connection conn, Class<T> clazz) throws Exception {
				StringBuilder sb = new StringBuilder();
				sb.append("select * from ").append(tbName);
				if (null != sqlWhere) {
					sb.append(" ").append(sqlWhere);
				}
				if (null != pageNo && null != pageSize) {
					sb.append(" limit ").append((pageNo - 1) * pageSize)
							.append(",").append(pageSize);
				}
				System.out.println(sb.toString());
				PreparedStatement ps = conn.prepareStatement(sb.toString());
				ResultSet rs = ps.executeQuery();
				return toObject(rs, clazz);
			}
		},clazz);
		return set;
	}

	private static <T> T toObject(ResultSet rs, Class<T> clazz)
			throws Exception {
		T obj = clazz.newInstance();
		String[] columnNames = getColumnNames(rs);
		if (null != columnNames && rs.next()) {
			for (String columnName : columnNames) {
				StringBuilder sbBuilder = new StringBuilder("set");
				sbBuilder.append(columnName.substring(0, 1).toUpperCase())
						.append(columnName.substring(1));
				try {
					Object value = rs.getObject(columnName);
					Method method = obj.getClass().getMethod(
							sbBuilder.toString(), value.getClass());
					method.invoke(obj, value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return obj;
	}

	private static String[] getColumnNames(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		String[] columnNames = new String[count];
		for (int i = 0; i < count; i++) {
			columnNames[i] = rsmd.getColumnLabel(i + 1);
		}
		return columnNames;
	}
}
