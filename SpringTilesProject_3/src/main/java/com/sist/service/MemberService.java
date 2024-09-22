package com.sist.service;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import com.sist.vo.MemberVO;

public interface MemberService {
	public MemberVO isLogin(String id, String pwd);
	@Autowired
	
	
}
