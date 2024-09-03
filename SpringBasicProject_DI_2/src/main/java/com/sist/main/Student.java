package com.sist.main;

import lombok.Data;

@Data
public class Student {
	private int hakbun;
	private String subject;
	private int kor, eng, math;
	private Human human=new Human();
	
	public void print() {
		System.out.println(hakbun);
		System.out.println(human.getName());
		System.out.println(sex);
		System.out.println(subject);
		System.out.println(human.get);
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(math);
		
	}
}
