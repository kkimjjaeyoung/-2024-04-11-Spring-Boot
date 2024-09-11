package com.sist.temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GoodsDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public GoodsDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL, "hr", "happy");
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	public void disConnection() {
		try {
			
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	public void insert(StoreVO svo, InputVO ivo) {
		try {
			getConnection();
			conn.setAutoCommit(false);
			String sql="INSERT INTO input VALUES(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ivo.getNo());
			ps.setInt(2, ivo.getGno());
			ps.setInt(3, ivo.getPrice());
			ps.executeUpdate();
			
			sql="INSERT INTO store VALUES(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ivo.getNo());
			ps.setInt(2, ivo.getGno());
			ps.setInt(3, ivo.getPrice());
			ps.executeUpdate();
			conn.commit();
		}catch (Exception ex) {
			ex.printStackTrace();
			try {
				conn.rollback(); //전체 sql문장 취소
			}catch (Exception exx) {
				// TODO: handle exception
			}
		}finally {
			try {
				conn.setAutoCommit(true);//원상복귀
			}catch (Exception ex) {
				disConnection();
			}
			
		}
	}
}
