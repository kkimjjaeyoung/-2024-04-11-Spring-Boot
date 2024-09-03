/*
 * 스프링 : 오픈소스 라이브러리(확장성이 좋음)
 * 
 * 스프링 지원 라이브버리
 *   1. core : 객체 생성, 객체 소명, 객체 관리 
 *   	객체 생명주기(컨테이너)
 *   2. aop(행간지향적 프로그램) : 공통 기능을 모아 자동으로 처리(oop의 보완)
 *   
 *   3. Data Access : JDBC / ORM / OXM / JMS	(ORM, OXM : XML 파싱, JMS : Messege Service)
 *   4. WEB : MVC
 *   기타 : Spring Data(빅데이터 분석)
 *   		Spring Security
 *   
 *   1). DI : 모든 스프링의 기본(클래스 관리자)
 *  	- 프로그램에 맞게 클래스를 관리
 *  	- 다른 프레임워크와 호완성이 좋다
 *  	- 바로 걷어낼 수 있다
 *  	- XML 기반(Spring4) / Annotation 기반(Spring5)
 *  		DI : 클래스(컴포넌트/빈)를 저장해 관리하는 컨테이너 클래스
 *  		클래스(컴포넌트/빈) : BeanFactory(core[DI]) - ApplicationContext(core, AOP) - GenericXmlApplicationContext - WebApplicationContext(core, AOP, MVC)
 *  
 *  	XML : 공통기반(데이터베이스 연결)
 *  	어노테이션 기반 : 사용자 정의(개발자 각각)
 *  
 *  스프링 프레임워크의 특징
 *  1. 경량 컨테이너 (DI+DL)
 *  	1). 객체 저장
 *  		<bean id="" class="">
 *  	2). 객체 찾기
 *  		getBean("")
 *  	3). 객체 소멸
 *  2. POJO방식(상속, 인터페이스 구현없이 순수하게 자바로만 사용하는 일반클래스)
 *  	- 다른 클래스에 영향이 없어 자유로히 구현 가능
 *  	- 특정 프레임워크 기술에 의존하지 않음
 *  	- 결합성이 낮은 프로그램 개발에 사용
 *  3. 유지보수가 편리(클래스가 독립적으로 저장)
 *  4. 확장성
 *  5. 필요한 모든 라이브러리 지원
 *  
 *  DI 
 *  1. setter DI : setXxx() 	-	변수의 초기화
 *  2. 생성자 DI : 
 *  3. 메소드 DI : 객체생성시/객체소멸시		-	클래스와 클래스 연관관계 설정
 *  
 *  
 *  1. XMl기반
 *  2. Annotation
 *  3. 자바 기반
 *
 *  
 *   ***스프링에서 클래스 등록 : 모든 클래스 등록(VO만 제외)
 *   클래스 등록
 *   1. XML
 *   	<bean id="" class=""> : 한개의 클래스만 등록
 *   	<context:component-scan basepackage=""> : 선별적이여야함. 등록된 클래스는 반드시 어노테이션.
 *   		@Component : 일반 클래스
 *   		@Repository : DAO(저장소) 
 *   		@Service : BI(기능통합)
 *   		@Controller : Model(forward/redirect)
 *   		@RestController : Model
 *   		@ControllerAdvice : 통합 예외처리
 *   		-- @Bean : XML없이 처리
 *   2. DI : XML에서만 사용 가능(맴버변수의 초기화)
 *   	class A{ 
 *   		private int a,b;
 *   		public void setA(int a){
 *  			this.a=a;
 *  		}
 *  		public void setB(int b){
 *  			this.b=b;
 *  		}
 *  		public A(int a, int b){
 *  			this.a=a;
 *  			this.b=b;
 *  		}
 *  	}
 *  
 *  	<bean id="aa" class="A"
 *  		p:a="10"
 *  		p:b="20"
 *			c:a="100" c:b="200"
 *		/>
 *   
 * 		p:name="aaa" 	-	일반 변수
 * 		p:name-ref="id명"		-	클래스객체(id명)  				
 */

package com.sist.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

public class MainClass {
	
	public static void main(String[] args) {
		//컨테이너에 등록
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
					
					);
		}
	}	
}
