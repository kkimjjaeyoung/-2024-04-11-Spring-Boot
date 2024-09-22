package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import com.sist.mapper.*;
import com.sist.vo.*;


public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	public List<RecipeVO> recipeListData(@Param("start") int start, @Param("end") int end){
		return mapper.recipeListData(start, end);
	}
	
	public int recipeTotalPage() {
		return mapper.recipeTotalPage();
	}
	
	public RecipeVO recipeDetailData(int no) {
		mapper.recipeHitIncrement(no);
		return mapper.recipeDetailData(no);
	}
}
