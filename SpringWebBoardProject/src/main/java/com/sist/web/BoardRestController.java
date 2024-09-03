package com.sist.web;

import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//자바스크립트나 다른 언어를 연결할때 사용 : 파일제어하지 않음. 문자열,JSON, JavaScript전송 가능
@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@PostMapping(value="board/update_ok.do", produces="text/html; charset=UTF-8")
	public String board_update_ok(BoardVO vo) {
		
		String js="";
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true) {
			
		}
		else {
			
		}
		return js;
	}
	
	@PostMapping(value="board/delete_ok.do", produces="text/html; charset=UTF-8" )
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
}
