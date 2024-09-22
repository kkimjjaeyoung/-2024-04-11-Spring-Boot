/*
 * 자바스크립트 이용때
 * 	경우의 수가 많은 경우
 * 
 */
package com.sist.web;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.sist.dao.*;
import com.sist.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")	//포트가 다른 경우
public class MemberRestController {
	@Autowired
	private MemberService mService
	
	@Async	//비동기화 
	@PostMapping("member/login_ok.do", produces="text/html; charset=UTF-8")
	public String member_login_ok(String id, String pwd, HttpSession session) {
		String result="";
		MemberVO vo=mService.isLogin(id, pwd);
		if(vo.getMsg().equals("NOID")) {
			result="<script>"
					+ "alert(\"아이디가 존재하지 않습니다\");"
					+ "history.back();"
					+ "</script>";					
		}
		else if(vo.getMsg().equals("NOPWD")) {
			result="<script>"
					+ "alert(\"비밀번호가 틀립니다\");"
					+ "history.back();"
					+ "</script>";
		}
		else {
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("admin", vo.getAdmin());
			result="<script>"
					+ "location.href=\"../main/main.do\";"
					+ "</script>";
			/*
			 * 스프링을 통해 내장객체를 매개변수로 받는다
			 * HttpSession
			 * HttpServletRequest : Cookie
			 * HttpServletResponse : Cookie, 업로드
			 * Model : 데이터 전송(forward=request를 jsp로 전송)
			 * RedirectAttributes : sendRedirect();
			 */
		}
		return result;
	}
}
