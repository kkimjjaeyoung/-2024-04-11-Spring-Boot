package com.sist.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.DataBoardVO;

public class DataBoardMapper {

	
	
	
	
	//상세보기
	/*@Update("UPDATE spring_databoard SET"
			+ "hit=hit+1"
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,name,subject,content, TO_CHAR(")
	*/
	public DataBoardVO databoardDetailData(int no) {
		mapper.hitIncrement
	}
	
	//삭제하기
	@Select("SELEcT filename, filecount, FROM spring_databoard"
			+ "WHERE no=#{no}")
	public DataBoardVO databoardFileInfoData(int no);
	@Select("SELECT pwd FROM spring_databoard WHERE no=#{no")
	public String databoardGetPassword(int no);
	
	@Delete("DELETE FROM spring_databoard"
			+ "WHERE no=#{no")
	public void databoardDelete(int no);
}
