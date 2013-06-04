package com.jdbc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 
 * @author Jerval
 * 
 * @date 2011-5-17
 */
public class ClobDemo {

	public static void main(String[] args) throws Exception {
//		create();
//		readToString(1);
		readToFile(1);
	}

	private static void create() throws Exception {
		// get connection
		Connection conn = JDBCUtilsSingleton.getInstance().getConnection();
		// create statement
		PreparedStatement ps = conn
				.prepareStatement("insert into clob_test(content) values(?)");
		// execute query
		File file = new File("src/com/jdbc/CRUD.java");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		ps.setCharacterStream(1, reader);
		int i = ps.executeUpdate();
		System.out.println(i);
		JDBCUtilsSingleton.getInstance().close(null, ps, conn);
	}
	private static void readToString(int id) throws Exception {
		// get connection
		Connection conn = JDBCUtilsSingleton.getInstance().getConnection();
		// create statement
		PreparedStatement ps = conn
				.prepareStatement("select content from clob_test where id = ?");
		// execute query
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		// get table meta data
		ResultSetMetaData metaData = rs.getMetaData();
		// get column count
		int num = metaData.getColumnCount();
		// iterate column name
		for (int i = 1; i <= num; i++) {
			System.out.print("[" + metaData.getColumnName(i) + "]");
		}
		System.out.println();
		for (int i = 1; i <= num; i++) {
			System.out.print("[" + metaData.getColumnTypeName(i) + "]");
		}
		System.out.println();
		while (rs.next()) {
			for (int i = 1; i <= num; i++) {
				System.out.print(rs.getString(metaData.getColumnName(i)));
			}
			System.out.println();
		}
		JDBCUtilsSingleton.getInstance().close(rs, ps, conn);
	}
	private static void readToFile(int id) throws Exception {
		// get connection
		Connection conn = JDBCUtilsSingleton.getInstance().getConnection();
		// create statement
		PreparedStatement ps = conn
				.prepareStatement("select content from clob_test where id = ?");
		// execute query
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			File file = new File("C:/CRUD_bak.java");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			// method 1,write file by string
//			writer.write(rs.getString("content"));
			
			// method 2,write file by char
			//way1
//			Clob clob = rs.getClob("content");
//			Reader reader = clob.getCharacterStream();
			//way2 recommended
			Reader reader = rs.getCharacterStream("content");
			char[] buff = new char[1024];
			for(int i=0;(i=reader.read(buff))>0;){
//				writer.write(buff);//会写入多余字符
				writer.write(buff, 0, i);
			}
			writer.flush();
			writer.close();
			reader.close();
		}
		JDBCUtilsSingleton.getInstance().close(rs, ps, conn);
	}

	
}
