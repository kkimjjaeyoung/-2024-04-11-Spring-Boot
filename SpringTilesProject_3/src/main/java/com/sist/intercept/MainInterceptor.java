/*
 * main.do -> login(자동로그인)
 * 		main.do(사이트 시작 요청)
 * 		 -> DIspatcherServlet(Front Controller : 요청받기, 결과값 전송. @Controller)
 * 		 -> HandlerMapping(Model찾기
 * 				--어노테이션
 * 					@GetMapping, @PostMapping, @RequestMapping
 * 		 ->return "main/main(postHandle()
 * 		 -> ViewResolver(request)
 * 		 -> JSP
 */

package com.sist.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MainInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-- preHandle() Call --");
		return super.preHandle(request, response, handler);
	}
	// 수행후 return "main/main" -- ViewResolver로 전송하기 전 : 권한처리, 자동로그인, ID저장
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-- postHandle() Call --");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-- afterHandle() Call --");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	
}
