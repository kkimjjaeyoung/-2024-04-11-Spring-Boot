package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller		//모델클래스. HandlerMapping에서 처리
public class BoardController {
	@Autowired
	private BoardDAO dao;
	//RequestMapping(GET+POST). - get과 post 분류 권장
	@GetMapping("board/list.do")
	public String board_list(String page, Model model) {
		//사용자로부터 받는 값	-	model객체(결과값 전송 객체)
		if(page==null)	page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		List<BoardVO> list=dao.boardListData(start, end);
		//총페이지
		int count=dao.boardRowCount();
		int totalpage=(int)(Math.ceil(count/(double)rowSize));
		count=count-((rowSize*curpage)-rowSize);
		//출력에 필요한 데이터를 list.jsp로 전송
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		
		return "board/list";	//.jsp붙이면 오류.
	}
	//게시판 입력창을 요청
	@GetMapping("board/insert.do")
	public String board_insert() {
		return "board/insert";
	}
	@PostMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo) {		//커맨드 객체. vo단위로 값을 받는 경우
		//dao 연동
		dao.boardInsert(vo);
		return "redirect: list.do";
	}
	
	
	
	
	
	@GetMapping("board/delete.do")
	//405 허용되지 않은 메소드 	-	get/post 에러
	//400 잘못된 요청(bad request)		-	매개변수의 데이터형이 틀린 경우
	public String board_delete(int no, Model model) {
		model.addAttribute("no", no);
		return "board/delete";
	}
	
	/*
	@PostMapping("board/delete_ok.do")
	@ResponseBody
	//getParameter() : 스프링(DispatcherServlet)이 처리
	public String board_delete_ok(int no, String pwd) {
		String js="";
		boolean bCheck=dao.boardDelete(no, pwd);
		if(bCheck==false) {
			js="<script>"
					+ "alert(\"Password fail\")"
					+ "history.back();"
					+ "</script>";
		}
		else {
			js="<script>"
					+ "location.href=\"
					+ "history.back();"
					+ "</script>";
		}
		return js;
	}
	*/
}
