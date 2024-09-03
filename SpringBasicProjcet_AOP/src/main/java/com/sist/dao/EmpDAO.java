package com.sist.dao;

import java.util.*;
import java.sql.*;


public class EmpDAO {
	private MyDataSource ds;
	private PreparedStatement ps;
	private Connection conn;
	public EmpDAO(MyDataSource ds) {
		this.ds=ds;
		try {
			Class.forName(ds.getDriver());
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(ds.getUrl(), ds.getUsername(), ds.getPassword())
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
	//기능설정 
	//around : 수행시간 측정(트랜잭션)
	public List<EmpVO> empListDate(){
		List<EmpVO > list=new ArrayList<EmpVO>();
		try {
			//getconnecton은 aop로 처리	-	before
			String sql="SELECT empno, job, TO_CHAR(hiredate, 'YYYY-MM-DD'), sal"
					+ "FROM emp ORDER BY empno ASC";
			
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setSal(rs.getInt(5));
				list.add(vo);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}//finally의 disconnection부분도 aop처리	-	after
		return list;
	}
	public EmpVO empDetailData(int empno) {
		EmpVO vo=new EmpVO();
		try {
			String sql="SELECT empno, ename, job, hiredate, sal"
					+ "FROM emp "
					+ "WHERE empno="+empno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setDbday(rs.getString(4));
			vo.setSal(rs.getInt(5));
			rs.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return vo;
	}
}
