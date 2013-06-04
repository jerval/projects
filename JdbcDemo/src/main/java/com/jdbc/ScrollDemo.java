package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 通过滚动数据集实现分页查询
 * 
 * @author Jerval
 * 
 */
public class ScrollDemo {

	public static void main(String[] args) {
		//read(4, 5);
		readAndUpdate();
	}

	private static void read(int strat, int num) {
		Connection conn = JDBCUtils.getConnection();
		String sql = "select * from tbuser";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			int i = 0;
			rs.absolute(strat);
			while (rs.next() && i < num) {
				i++;
				System.out.println(rs.getString("username") + "\t"
						+ rs.getString("password") + "\t" + rs.getInt("age")
						+ "\t" + rs.getTimestamp("regDate"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
	}
	
	private static void readAndUpdate() {
		Connection conn = JDBCUtils.getConnection();
		String sql = "select * from tbuser";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				System.out.println(username + "\t"
						+ rs.getString("password") + "\t" + rs.getInt("age")
						+ "\t" + rs.getTimestamp("regDate"));
				if("uuu".equals(username)){
					rs.updateString("password", "1111");
					rs.updateRow();
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.close(rs, ps, conn);
		}
	}
}
