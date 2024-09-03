package com.sist.main;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext app=new GenericXmlApplicationContext("app2.xml");		//객체 생성
	}
	Board b=(Board)app.getBean("board");		//필요한 기능 호출
	b.list();
	b.insert();
	app.close();		//객체 소멸
}
