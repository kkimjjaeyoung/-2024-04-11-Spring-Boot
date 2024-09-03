/*
 * maven : ant
 * 	1. 라이브러리 관리 : pom.xml
 *  2. 프로젝트 관리 : 버전 관리
 *  3. 배포 관리 : 자동으로 war(웹)
 *  
 *  스프링 : DI/AOP/MVC/MyBatis
 *  
 *  DI 
 *   1. 클래스 등록
 *   	<bean id="" class=""> 	-	한개의 클래스 등록
 *   	<context:component-scan basepackage="">		-	여러개 클래스를 동시에 메모리 할당. 반드시 메모리 할당할 클래스 구분. class위에 어노테이션을 이용해 구분
 *   		클래스 유형별로 구분	
 *   			일반 클래스 : @Component
 *   			데이터베이스 연동 : @Repository
 *   			관련된 DAO를 통합 : @Service
 *   			Model 클래스 : @Controller / @RestController(Json, Restful, GET, POST, PUT, DELETE)
 *   			통합예외처리 : @ControllerAdvice
 *  		XML없이 사용
 *  			@Bean : 자바로만 코딩하는 방식
 *  **스프링은 컨테이너다(클래스 관리ㅈ) ; MVC는 스프링의 일부 라이브러리
 *  	맴버변수 초기화(DI)
 *  		1. setter : setXxx(주입)
 *  			p:name
 *  		2. 생성자 이용
 *   	 		c:name 
 *   
 *   MyBatis : @Select... 
 *   			매개변수는 반드시 1개(여러개 사용법은 별도)
 *   
 *   
*/

package com.sist.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.vo.*;
import com.sist.dao.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					);
			
		}
	}

}
