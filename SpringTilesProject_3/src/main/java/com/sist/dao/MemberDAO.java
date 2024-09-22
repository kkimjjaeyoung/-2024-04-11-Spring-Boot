/*
 * 1. 스프링에 관리(클래스)
 * 		DAO - @Repository
 * 		Service - @Service
 * 		Manager - @Component : 일반클래스
 * 		Controller - @Controller
 * 		Interceptor - xml : <bean>
 * 		AOP - @Component : 일반클래스
 * 		/ interface : 메모리 할당 불가능
 * 		/ ~VO : 클래스 : 데이터형
 * 		제외(클래스)	
 * 			1). 데이터형 클래스(변수로 구성) : 사용자 정의 데이터형
 * 			2). 액션 클래스(메소드로 구성) : 기능을 가진 클래스 
 * 
 */

package com.sist.dao;

import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired		//스프링에서 메모리 할당이 된 경우만 사용가능
	private MemberMapper mapper;
	
	public int memberIdCount(String id) {
		return mapper.memberIdCount(id);
	}
	
	public String memberGetPassword(string id) {
		return mapper.memberGetPassword(null)
	}
	
}
