package com.sist.web;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.service.*;
import com.sist.vo.*;


@Controller
public class FoodController {
	@Autowired
	private FoodService fService;
	
	@GetMapping("food/detail_before.do")
	public String food_detail_before(int no,HttpServletResponse response,RedirectAttributes ra)
	   {
		   // Cookie제작 => 저장 => 브라우저 전송 HttpServletResponse response를 매개변수로 받는다 
		   // 전송 => Model : forward 
		   // 전송 => RedirectAttributes : sendRedirect
		   Cookie cookie=new Cookie("food_"+no, String.valueOf(no));
		   // 쿠키는 저장위치 : 브라우저 , 문자열만 저장이 가능 
		   //                            키               값
		   //                         getName()         getValue()
		   cookie.setMaxAge(60*60*24); // 초단위 저장 => 저장 기간  
		   cookie.setPath("/"); // 저장위치 
		   // 브라우저로 전송 
		   response.addCookie(cookie);
		   ra.addAttribute("no", no);
		   //ra.addFlashAttribute("no", no);
		   return "redirect:../food/detail.do";
	   }
	   @GetMapping("food/detail.do")
	   // recipe/detail.do?no=
	   public String food_detail(int fno,Model model)
	   {
		   // 데이터베이스 연결 => 데이터를 읽기 
		   FoodVO vo=fService.foodDetailData(fno);
		   // detail.jsp로 출력할 데이터 보내준다 
		   model.addAttribute("vo", vo);
		   
		   List<String> mList=new ArrayList<String>();
		   List<String> iList=new ArrayList<String>();
		   
		   model.addAttribute("mList", mList); // 레시피 방식
		   model.addAttribute("iList", iList); // 이미지
		   
		   
		   // Model은 JSP로 전송시에 사용 : forward
		   model.addAttribute("main_jsp", "../food/detail.jsp");
		   return "main/main";
	   }

	   @GetMapping("food/list.do")
	   public String food_list(String page,Model model,HttpServletRequest request)
	   {
	 	  if(page==null)
	 		  page="1";
	 	    int curpage=Integer.parseInt(page);
	 	    Map map=new HashMap();
	 	    map.put("start", (curpage*20)-19);
	 	    map.put("end", curpage*20);
	 	    List<FoodVO> list=fService.foodListData(map);
	 	    int count=fService.foodRowCount();
	 	    int totalpage=(int)(Math.ceil(count/20.0));
	 	    
	 	    final int BLOCK=10;
	 	    int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	 	    int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	 	    
	 	    if(endPage>totalpage)
	 	    	endPage=totalpage;
	 	    
	 	    model.addAttribute("list", list);
	 	    model.addAttribute("count", count);
	 	    model.addAttribute("curpage", curpage);
	 	    model.addAttribute("totalpage", totalpage);
	 	    model.addAttribute("startPage", startPage);
	 	    model.addAttribute("endPage", endPage);
	 	    
	 	    
	 	  // include할 JSP를 지정 
	 	    model.addAttribute("main_jsp", "../food/list.jsp");
	 	  return "main/main";
	   }
	   
}
