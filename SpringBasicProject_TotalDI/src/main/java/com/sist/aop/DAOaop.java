package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DAOaop {
	public void before() {
		System.out.println("오라클 연결");
	}
	public void after() {
		System.out.println("오라클 해제");
	}
	//around
	//핵심 코딩
	//핵심처리/공통처리
	//이미지 저장, 받아오는 주소 수정
	/*
	 * 
	 * MyBatis : 라이브러리(공통사용부분 제거)
	 * around
	 * 	공통
	 * 	**	핵심
	 * 	공통
	 * 
	 * 트랜잭션 처리 setAutoCommif(false)
	 * 				처리
	 * 				commit
	 * LOG파일
	 * 
	 * 
	 */
	public Object around(ProceedingJoinPoint jp) {
		Object obj=null;
		long start=System.currentTimeMillis();
		System.out.println("호출된 메소드:"+jp.getSignature().getName());
		obj=
		long end=System.currentTimeMillis();
		System.out.println("소요시간:"+(end-start));
		return obj;

	}
	
	public void afterRetruning(Object obj) {
		System.out.println("관과값 자동 처리");
		System.out.println(obj);
	}
	
	public void afterThrowing(Throwable ex) {
		System.out.println("예외발생");
		System.out.println(ex.getMessage());
	}
}
