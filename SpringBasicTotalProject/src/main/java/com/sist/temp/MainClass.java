package com.sist.temp;
import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<SawonVO> list=new ArrayList<SawonVO>();
		SawonVO hong=SawonVO.newInstance();
		System.out.println("홍="+hong);
		hong.setName("홍길동");
		hong.setDept("개발부");
		list.add(hong);
		
		SawonVO shim=SawonVO.newInstance();
		System.out.println("주소="+shim);
		hong.setName("심청이");
		hong.setDept("기획부");
		list.add(shim);
		
		SawonVO park=SawonVO.newInstance();
		System.out.println("주소="+park);
		hong.setName("박문수");
		hong.setDept("영업");
		list.add(park);
		
		
	}
	

}
