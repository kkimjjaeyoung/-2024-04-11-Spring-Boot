package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

@Controller
public class EmpController {
	//스프링에서 객체 주소를 받는 경우 - 메소드 안에서는 받을 수 없다(필요한 객체는 객체로 받는다)
	@Autowired
	private EmpDAO eDao; 
	
	//사용자 요청별로 처리(@GetMapping/@PostMapping/@RequestMapping) - RequestMapping은 스프링6버전에선 제거
	@GetMapping("emp/list.do")
	public String emp_list(Model model) {
		//DB연동
		List<EmpVO> list=eDao.empListData();
		model.addAttribute("list", list); 
		
		return "emp/list";
	}
	
	@GetMapping("emp/detail.do")
	public String emp_detail(int empno, Model model) {
		
		EmpVO vo=eDao.emp_detailData(empno);
		model.addAttribute("vo", vo);
		return "emp/detail";
	}
}
