package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	@Async
	@GetMapping("member/login.do")		//자동로그인
	public String member_login() {
		return "user/member/login";
	}
	
	@PostMapping("member/login_ok.do")
	public String member_login_ok(String id, String pwd, HttpSession session) {
		return "redirect: ../main/main.do"; 
	}
}
