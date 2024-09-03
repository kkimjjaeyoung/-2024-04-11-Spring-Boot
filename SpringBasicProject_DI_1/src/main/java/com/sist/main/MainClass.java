package com.sist.main;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//클래스 등록
		ApplicationContext app=new ClassPathXmlApplicationContext("app1.xml");
		//classpath : 자동 인식하는 위치
		Sawon sa1=(Sawon)app.getBean("sal");
		sa1.print();
	
		Sawon sa2=(Sawon)app.getBean("sa2");
		sa2.print();
		
		Sawon sa3=(Sawon)app.getBean("sa3");
		sa3.print();
	}

}
