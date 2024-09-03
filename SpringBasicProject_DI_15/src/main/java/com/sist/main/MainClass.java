package com.sist.main;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
import com.sist.vo.GoodsVO;

@Component("mc")
//mainclass는 스프링에서 관리. 필요한 경우 반드시 스프링을 통해 객체를 얻어온다
//new mainclass : 스프링을 통하지 않아 @autowired가 실행되지 않는ㄷ
public class MainClass {
	@Autowired
	private GoodsDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");	//동시에 로딩
		MainClass mc=(MainClass)app.getBean("mc");
		String[] tabs= {"", "goods_all","goods_best","goods_new", "goods_special"};
		Scanner scan=new Scanner(System.in);
		System.out.println("1. 전체상품, 2. 베트스상품, 3. 신상품, 4. 특가상품");
		int cno=scan.nextInt();
		System.out.println("페이지 입력:");
		int page=scan.nextInt();
		int rowSize=20;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		Map map=new HashedMap();
		map.put("table_name", tabs[cno]);
		map.put("start", start);
		map.put("end", end);
		List<GoodsVO> list=mc.dao.goodsListData("");
		int totalpage=mc.dao.goodsTotalPage(map);
		System.out.println(page+totalpage);
		for(GoodsVO vo:list) {
			System.out.println(vo.getNo()+vo.getGoods_name());
		}
		System.out.println();
		System.out.println("상세 상품 선택");
		int no=scan.nextInt();
		map.put("no", no);
		GoodsVO vo=mc.dao.goodsDetailData(map);
		System.out.println("상품번호: "+vo.getNo());
		System.out.println("상품명: "+vo.getGoods_name());
		System.out.println("상품가격: "+vo.getGoods_price());
		System.out.println("상품소개: "+vo.getGoods_sub());
		System.out.println("상품이미지: "+vo.getGoods_poster());
	}

}
