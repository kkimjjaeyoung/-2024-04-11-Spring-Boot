/*
 * 1. mapper작성(sql문장 구현)
 * 2. dao구현
 * 3. service 등록(/Service)
 * 4. service 구현(/ServiceImpl)
 */

package com.sist.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;

@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeDAO dao;

	@Override
	public List<RecipeVO> recipeListData(Map map) {
		// TODO Auto-generated method stub
		return dao.recipeListData(map);
	}

	@Override
	public int recipeRowCount() {
		// TODO Auto-generated method stub
		return dao.recipeRowCount();
	}

	@Override
	public void recipeHitIncrement(int no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		// TODO Auto-generated method stub
		return recipeDetailData(no);
	}

	@Override
	public int chefTotalPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RecipeVO> chefMakeRecipeData(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int chefMakeRecipeTotalPage(String chef) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RecipeVO recipeCookieInfoData(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChefVO> chefListData(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecipeVO> recipeFindData(Map map) {
		// TODO Auto-generated method stub
		return dao.recipeFindData(map);
	}

	@Override
	public int recipeFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return dao.recipeFindTotalPage(map);
	}

	
	
}
