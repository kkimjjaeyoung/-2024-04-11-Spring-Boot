/*
 * 브라우저 요청 : 항상 .do 필요
 * 	- DispatcherServlet : MVC의 Controller구조. 매개변수 생성
 *   -- model : 처리
 *    --- JSP 관리 : JSP찾아서 request 전송
 *     ---- View : JSP로 전송
 *     
 * 1. DispatcherServlet : 사용자 요청 수령
 * 2. HandlerMapping : DispatcherServlet으로부터 받은 데이터를 받아 처리(model, @Controller : DispatcherServlet -- 위임받아 처리)
 * 		- 구분자  : @GetMapping / @PostMapping / @RequestMapping
 * 3. ViewResolver : request를 받아서 JSP탐색 후 전송
 * 		- JSP의 경로명 지정 : prefix="" 		 
 * 4. VIew(JSP) :  
 */

/*
 * 스프링
 *  DI : 개발자가 만들 클리스/라이브러리를 제어
 *  	- 1. 클래스 : 멤버변수에 대한 초기화(명시적 초기화:개발자, 생성자, setter)
 *  AOP : 공통적으로 사용하는 기능을 자동으로 호출이 가능하게 만듬(공통모듈)
 *   	- 메소드 위치
 *   		public void 
 *   		try{
 *   		//before
			 *   getconnection()
			 *   conn.setAutoCommit(false)			--Around
			 *   insert				--핵심코딩
			 *   insert				--핵심코딩
			 *   conn.commit				--Around
 *   		}catch{
 *    		//after-throwing
				 *   ex.printStackTrace()
				 *   conn.rollback()
 *   		}finally{
 *   		//after
			 *   conn.setAutoCommit(true)
			 *   disConnection()   
 *   		}
 *   		//after-returning
 *   		return				--정상수행
 *  MVC : 분리해서 작업(Front:View, Back:server/db)
 *  Interceptor : 
 */

/*
 * 1. 라이브러리 추가 : pom.xml / gradle(boot에서 사용하는 방식. .properties)
 * 2. 버전 변경(기본 1.6 -1.8)
 * 3. web.xml 변경
 * 4. 패키지-클래스
 * 5. 메모리 할당 요청(application.xml)
 * 6. 클래스마다 어노테이션 올리기
 * 7. db연동
 * 8. JSP에서 화면출력
 */
package com.sist.web;


public class MainController {

}
