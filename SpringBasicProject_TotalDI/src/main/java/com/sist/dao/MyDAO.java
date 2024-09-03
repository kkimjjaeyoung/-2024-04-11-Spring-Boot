package com.sist.dao;

public class MyDAO {
	//공통모듈
	public void getConnection() {
		System.out.println("오라클 연결");
	}
	
	public void disConnection() {
		System.out.println("오라클 해제");
	}

	//AOP대상
	//OOP에서 하지 못한 자동호출이 가능하게 만든 상태(OOP보완)
	public void select() {
		//getConnection();	//before
		System.out.println("SELECT문장 처리");
		//disConnection();	//after
	}
	
	public void insert() {
		//getConnection();
		System.out.println("insert문장 처리");
		//disConnection();
	}
	
	public void delete() {
		//getConnection();
		int a=10/0;
		System.out.println(a);
		System.out.println("delete문장 처리");
		//disConnection();
	}
	
	public void update() {
		//getConnection();
		System.out.println("update문장 처리");
		//disConnection();
	}
	
	public String find(String fd) {
		return fd+"찾기 완료";
	}
	

}
