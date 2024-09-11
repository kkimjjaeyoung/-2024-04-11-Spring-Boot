package com.sist.commons;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//공통 예외처리 : 모든 Controller 예외처리
@ControllerAdvice
public class CommonsException {
	@ExceptionHandler(SQLException.class)
	public void sqlException(SQLException ex) {
		System.out.println("DB에러");
		ex.printStackTrace();
		System.out.println("발생");
	}
	
	@ExceptionHandler(IOException.class)
	public void sqlException(IOException ex) {
		System.out.println("파일 입출력(io)에러");
		ex.printStackTrace();
		System.out.println("발생");
	}
	
	@ExceptionHandler(RuntimeException.class)
	public void sqlException(RuntimeException ex) {
		System.out.println("실행시(runtime) 에러");
		ex.printStackTrace();
		System.out.println("발생");
	}
	
	@ExceptionHandler(Exception.class)
	public void sqlException(Exception ex) {
		System.out.println("기타 에러");
		ex.printStackTrace();
		System.out.println("발생");
	}
}
