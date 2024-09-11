/*
 * 1. 스프링의 기본 기능 
 * 	DI : 클래스를 모아서 관리하는 목적(메모리 할당. 객체 생성/소멸.). vo(사용자정의 데이터형), 인터페이스(생성불가) 제외. 
 * 		클래스 1개에 대한 관리요청 : <bean>
 * 		패키지 단위 관리 : <component-scan base-package="패키지명">
 * 			클래스마다 구분
 * 			@Component : 일반 클래스
 * 			@Repository : DAO
 * 			@Service : DAO여러개 등록(BI)
 * 			@Controller : Model(요청처리). 화면제어
 * 			@RestController : Model(요청처리). 데이터 전송
 * 			@ControllerAdvice : 공통 예외처리
 *  AOP : 소스 중복 제거, 공통 기능 적용 등 자동화. 기능 수행 지정(프로그램 개발 등)
 *  MVC : 
 *  데이터베이스 : ORM(MyBatis) 
 */
package com.sist.aop;

public class CommonsFooterAOP {

}
