package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface FoodMapper {
	@Select("SELECT fno, name, type, phone, address, score, theme, poster, images, time, parking, content, rdays, jjimcount, likecount, hit, num"
			+ "FROM (SELECT fno, name, type, phone, address, score, theme, poster, images, time, parking, content, rdays, jjimcount, likecount, hit, rownum as num"
			+ "FROM (SELECT fno, name, type, phone, address, score, theme, poster, images, time, parking, content, rdays, jjimcount, likecount, hit"
			+ "FROM food_house))"
			+ "WHERE num BETWE	EN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM food_house")
	public int foodRowCount();
}
