/*
 *	//스프링에서 관리
 * 1. ~DAO : 데이터베이스 연동
 * 2. ~Service : dAO여러개를 한개로 통합. 결합성 낮은 프로그램에
 * 3. ~Manager : Open API
 * 4. ~Controller : Model
 * 5. ~RestController : 자바스크립트, 코틀린, 플러터
 * 6. ~ControllerAdvice : 통합 예외처리
 * 	//개발자 관리
 * ~VO : 사용자 데이터형
 * ~Mapper : 관리불가(인터페이스)
 */
package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository	//DAO메모리 할당 요청(싱글턴으로 생성)
public class BoardDAO {
	//필요한 객체를 스프링으로부터 얻어오기(DI) : 자동주입(@AutoWired)
	@Autowired
	private BoardMapper mapper;	//구현된 클래스의 주소값 설정. 
	/* 메소드 안에선 어노테이션 사용 불가 
	 * 	1. class위 : TYPE(클래스 구분자)
	 *  2. 메소드 위 : METHOD(메소드 구분자)
	 *  3. 멤버변수 위 : FIELD(멤버변수 구분자)
	 *  4. 매개변수 옆 : PARAMETER(매개변수 구분자)
	 *  5. 생성자 위  : CONTSTRUCTOR(생성자 구분자)
	 */
	public List<BoardVO> boardListData(int start, int end){
		return mapper.boardListData(start, end);
	}
	
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);	//commit, .close() 포함
	}
	public int boardRowCount() {
		return mapper.boardRowCount();
	}
	
	
	
	public boolean boardDelete(int no, String pwd) {
		boolean bCheck=false;
		String db_pwd=mapper.boardGetPassword(no);
		if(pwd.equals(db_pwd)) {
			bCheck=true;
			mapper.boardDelete(no);
		}
		return bCheck;
	}
}
