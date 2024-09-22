package com.sist.service;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.RecipeVO;

public interface RecipeService {
	public List<RecipeVO> recipeListData(@Param("start") int start, @Param("end") int end);
	
	public int recipeTotalPage();	
	public RecipeVO recipeDetailData(int no);

}
