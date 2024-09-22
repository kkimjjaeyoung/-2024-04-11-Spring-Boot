package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;
import com.sist.dao.*;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO mDao;

	@Override
	public MemberVO isLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		MemberVO vo=new MemberVO();
		int count=mDao.memIdCount(id);
		if(count==0) {		//로그인한 상태
			vo.setMsg("NOID")
		}
		else {
			MemberVO dvo=mDao.memberGetPassword(id);
			if(pwd.equals(dvo.getPwd())) {
				vo.setId(dvo.getId());
				vo.setName(dvo.getName());
				vo.setAdmin(dvo.getAdmin());
				vo.setMsg("OK");
			}
			else {		//비밀번호가 틀린 상태
				vo.setMsg("NOPWD");
			}
		}
		return vo;
	}
	
}
