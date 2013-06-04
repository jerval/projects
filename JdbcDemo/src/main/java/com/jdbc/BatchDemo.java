package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * @author Jerval
 * 
 */
public class BatchDemo {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for(int i=0;i<100;i++){
			create(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("create time:" + (end - start));

		start = System.currentTimeMillis();
		createBatch();
		end = System.currentTimeMillis();
		System.out.println("createBatch time:" + (end - start));
	}

	public static void create(int i) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into tbuser(username,password,age,regDate) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "batch" + i);
			ps.setString(2, "12345");
			ps.setInt(3, i);
			ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.close(null, ps, conn);
		}
	}

	public static void createBatch() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into tbuser(username,password,age,regDate) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < 100; i++) {
				ps.setString(1, "batch" + i);
				ps.setString(2, "12345");
				ps.setInt(3, i);
				ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));

				ps.addBatch();
			}
			int[] results = ps.executeBatch();
			System.out.println(results.length);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			JDBCUtils.close(null, ps, conn);
		}
	}
}
