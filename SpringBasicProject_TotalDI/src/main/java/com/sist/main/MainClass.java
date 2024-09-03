package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.MyDAO;

/*
 * 1. DI : 클래스와의 연관관계. 메뉴얼(클래스 설정에 대한 정의)
 * 	1). XML 기반 : 전저정부 프레임워크
 *  2). Annotation기반 : 라이브러리 클래스 등록시 상속을 받아서 처리
 * 	3). XML + Annotaion : 라이브러리 등록시 xml, 사용자 정의는 어노테이션(프로젝트 공통사용부분은 XML, 개발자마다 개발 부분은 어노테이션)
 * 	4). 순수 자바 : xml(스프링은 클래스 관리자. 생성~소멸. 한개의 클래스를 등록)
 * 		<bean id="" class="" scope=""> 		--		@Bean("id")
 * 			패키지 단위 등록 : <context:component-scan base-package="패키지명">		--		<ComponentScan(basePackage={""}
 * 					<mybatis-spring base-package="">		--		@MapperScan(basePackage={""})
 * 				- 선택적 메모리 할당. 클래스 위에
 * 					@Component : 일반 클래스
 * 					@Repository : DAO
 * 					@Service : DAP 여러개 통합(BI)
 * 					@Controller : model(클래스 위에서 생략되면 웹처리 불가), forward, redirect, 화면변경제어
 * 					@RestController : Model(화면번경 아님), GEL=SELECT, POST=UPDATE, PUT=
 * 					@ControllerAdvice공통적으로 예외 처리
 * 
 * 					**스프링에서 등록된 객체 찾기 : getBean("id명")
 * 					**스프링에서 등록된 클래스를 관리 : 컨테이너(BeanFactory-ApplicationContext-AnnotationConfigApplicationContext / WebApplicationContext)
 * 2. AOP : 공통으로 사용되는 클래스의 기능을 모아서 처리(자동호출)
 * 		- Aspect : 공통으로 사용되는 기능을 모아 관리(공통모듈)
 * 		1) PointCut : 어떤 메소드에 적용
 * 		2) JoinPoint : 어떤 위치에 적용
 * 			public void display(){
 * 				***			--	before
 * 				try{
 * 					***	setAutoCommit(false)
 * 					처리부분 |- Around
 * 					***	commit() : 트랜잭션, 로그파일
 * 				} catch(Exception ex{
 * 					***		-- after-throwing : catch수행
 * 				} finally{
 * 					*** after
 * 				}
 * 				***	after-returning
 * 			}
 * 				
 * 		3) Advice : PointCut + JoinPoint
 * 		4) Weaving : 소스를 통합하는 역할
 * 3. MVC : 웹
 * 4. ORM : Mybatis
 * 5. 인터셉트
 * 6. 공통예외처리
 * 7. 보안
 * 8. 웹체팅
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MyDAO dao=(MyDAO)app.getBean("dao");
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		dao.find("Hello");
		String s=dao.find("Hello");
		System.out.println(s);
	}

}
