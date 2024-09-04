package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class RecipeController {
	@Autowired
	private RecipeDAO dao;
	
	//매칭 : 사용자 전송 URL
	@RequestMapping("recipe/list.do")
	/*
	 * int page=null - x
	 * string page=null
	 * vue/react -- int page
	 */
	public String recipe_list(String page, Model model) {
		if(page==null) page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		map.put("start", (curpage*20)-19);
		map.put("end", curpage*20);
		List<RecipeVO> list=dao.recipeListData(map);
		int count=dao.recipeRowCount();
		int totalpage=(int)(Math.ceil(count/20.0));
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)	endPage=totalpage;
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "recipe/list"; 
	}
	
		@GetMapping("recipe/detail.do")
		public String recipe_detail(int no, Model model) {
			//데이터베이스 연결
			//상소보기에서 출력할 데이터 전송
			return "recipe/detail";
		}
}
