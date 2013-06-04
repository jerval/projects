package com.jdbc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author Jerval
 * 
 * @date 2011-5-17
 */
public class BlobDemo {

	public static void main(String[] args) throws Exception {
//		create();
		read(1);
	}

	private static void create() throws Exception {
		// get connection
		Connection conn = JDBCUtilsSingleton.getInstance().getConnection();
		// create statement
		PreparedStatement ps = conn
				.prepareStatement("insert into blob_test(bit_file) values(?)");
		// execute query
		File file = new File("C:\\Follow.jpg");
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		ps.setBinaryStream(1, in);
		int i = ps.executeUpdate();
		System.out.println(i);
		JDBCUtilsSingleton.getInstance().close(null, ps, conn);
	}
	
	private static void read(int id) throws Exception {
		// get connection
		Connection conn = JDBCUtilsSingleton.getInstance().getConnection();
		// create statement
		PreparedStatement ps = conn
				.prepareStatement("select bit_file from blob_test where id = ?");
		// execute query
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			File file = new File("C:\\Follow_bak.jpg");
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			//way1
//			Blob blob = rs.getBlob("bit_file");
//			InputStream in = blob.getBinaryStream();
			//way2 recommended
			InputStream in = rs.getBinaryStream("bit_file");
			byte[] buff = new byte[1024];
			for(int i=0;(i=in.read(buff))>0;){
//				out.write(buff);//会写入多余字节
				out.write(buff, 0, i);
			}
			out.flush();
			out.close();
			in.close();
		}
		JDBCUtilsSingleton.getInstance().close(rs, ps, conn);
	}

	
}
