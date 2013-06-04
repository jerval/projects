package com.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;
import com.jdbc.JDBCUtils;
import com.jdbc.exception.BusinessException;

public class Templete {

	public static void callback(IConnection IConn) {
		Connection conn = JDBCUtils.getConnection();
		try {
			conn.setAutoCommit(false);
			IConn.doThing(conn,null);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new BusinessException(e1.getMessage(), e1);
			}
			throw new BusinessException(e.getMessage(), e);
		} finally {
			JDBCUtils.close(null, null, conn);
		}
	}
	public static <T> T callback(IConnection IConn,Class<T> clazz) {
		Connection conn = JDBCUtils.getConnection();
		T object = null;
		try {
			conn.setAutoCommit(false);
			object = IConn.doThing(conn,clazz);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new BusinessException(e1.getMessage(), e1);
			}
			throw new BusinessException(e.getMessage(), e);
		} finally {
			JDBCUtils.close(null, null, conn);
		}
		return object;
	}
}
