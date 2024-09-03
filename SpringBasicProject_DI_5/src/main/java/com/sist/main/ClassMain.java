package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.BoardDAO;
import com.sist.manager.BoardManager;
import com.sist.model.BoardModel;

public class ClassMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		BoardDAO dao=(BoardDAO)app.getBean("dao");
		dao.list();
		
		BoardManager bm=(BoardManager)app.getBean("bm");
		bm.manager();
		
		//아이디가 지정이 안된 상태 - 자동지정(클래스명, 첫자 소문자)
		BoardModel model=(BoardModel)app.getBean("boardModel");
		model.model();
	}

}
