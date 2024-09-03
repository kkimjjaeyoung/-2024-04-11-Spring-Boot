package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface BoardMapper {
	//목록(페이지나누기)
	@Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit, num"
			+ "FROM (SELECT no, subject, name, regdate, hit, rownum as num"
			+ "FROM (SELECT no, subject, name, regdate, hit"
			+ "FROM spring_board ORDER BY no DESC))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start") int start, @Param("end")int end);
	//boardList(1,10) - 구분자 전송 - @Param : 매개변수를 여러개 사용 가능
	//Map : 1개 이용시. 혹은 VO
	@Select("SELECT COUNT(*) FROM spring_board")
	public int boardRowCount();
	
	//추가
	@Insert("INSERT INTO spring_board(no,name,subject,content,pwd"
			+ "VALUES(sb_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd})")
	public void boardInsert(BoardVO vo);
	//상세보기
	
	//수정
	
	
	//삭제
	@Delete("DELETE FROM spring_board"
			+ "WHERE no=#{no}")
	public void boardDelete(int no);
	//검색
	
}