package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml");
		Member mem1=(Member)app.getBean("mem1");
		mem1.print();
		
		Member mem2=(Member)app.getBean("mem1");
		mem1.print();
		
		Member mem3=(Member)app.getBean("mem1");
		mem1.print();
		
		Member mem4=(Member)app.getBean("mem1");
		mem1.print();
		
		
	}

}
