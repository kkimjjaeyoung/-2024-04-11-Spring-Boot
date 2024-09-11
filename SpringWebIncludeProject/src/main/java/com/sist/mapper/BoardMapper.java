package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface BoardMapper {
  @Select("SELECT no,subject,name,"
		 +"TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,group_tab,num "
		 +"FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num "
		 +"FROM (SELECT no,subject,name,regdate,hit,group_tab "
		 +"FROM spring_replyboard ORDER BY no DESC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<ReplyBoardVO> boardListData(@Param("start") int start,
		    @Param("end") int end);
  @Select("SELECT COUNT(*) FROM spring_replyboard")
  public int boardRowCount();
  
  @Insert("INSERT INTO spring_replyboard(no,name,subject,content,pwd,group_id) "
		 +"VALUES(srb_no_seq.nextval,#{name},#{subject},"
		 +"#{content},#{pwd},"
		 +"(SELECT NVL(MAX(group_id)+1,1) FROM spring_replyboard))")
  public void boardInsert(ReplyBoardVO vo);
  
  // 상세보기 
  @Update("UPDATE spring_replyboard SET "
		 +"hit = hit+1 "
		 +"WHERE no=#{no}")
  public void hitIncrement(int no);
  
  @Select("SELECT no,name,subject,content,hit,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday "
		 +"FROM spring_replyboard "
		 +"WHERE no=#{no}")
  public ReplyBoardVO boardDetailData(int no);
  // 수정 
  
  
  @Update("")
  public void boardUpdate(ReplyBoardVO vo);
  // 삭제 
  @Select("SELECT root, depth FROM spring_replyboard")
  public ReplyBoardVO boardDeleteInfoData(int no);
  
  @Delete("DELETE FROM spring_replyboard"
  		+ "WHERE np=#{no}")
  public void boardDelete();
  
  @Update("UPDATE spring_replyboard SET"
  		+ "subject='관리자가 삭제한 게시물입니다.',"
  		+ "content=;관리자가 삭제한 게시물입니다'"
  		+ "WHERE no=#{no}")
  public void boardSubjectUpdate(int no);
  
  @Update("UPDATE spring_replyboard SET"
  		+ "depth=depth-1"
  		+ "WHERE no=#{no}")
  public void boardDepthDocrement(int no);
  // 답변하기
  @Select("")
  public ReplyBoardVO boardGroupData(int no);
  
  @update("")
  public 
  // 검색 = 동적쿼리 
  
}