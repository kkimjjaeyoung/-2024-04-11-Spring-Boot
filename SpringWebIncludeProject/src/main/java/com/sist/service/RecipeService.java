package com.sist.service;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;
import com.sist.vo.*;

public interface RecipeService {
	public List<RecipeVO> recipeListData(Map map);
	public int recipeRowCount();
	public void recipeHitIncrement(int no);
	public RecipeDetailVO recipeDetailData(int no);
	public List<ChefVO> chefListData(Map map);
	public int chefTotalPage();
	public List<RecipeVO> chefMakeRecipeData(Map map);
	public int chefMakeRecipeTotalPage(String chef);
	public RecipeVO recipeCookieInfoData(int no);
	public List<RecipeVO> recipeFindData(Map map);
	public int recipeFindTotalPage(Map map);
}
