package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface FoodMapper {
	//list
	@Select("SELECT fno, poster, name, theme, images, num "
			+ "FROM (SELECT fno, poster, name, theme, images, rownum as num "
			+ "FROM (SELECT fno, poster, name, theme, images "
			+ "FROM food_house)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	@Select("SELECT COUNT(*) FROM food_house ")
	public int foodRowCount();
	
	//상세보기
	@Update("UPDATE food_house SET"
			+ "hit=hit+1"
			+ "WHERE no=#{no}")
	public void foodHitIncrement(int no);
	@Select("SELECT * FROM food_house"
			+ "WHERE no=#{no}")
	public FoodVO foodDetailData(int no);
		
	//맛집 검색
	/*  



	*/
}
