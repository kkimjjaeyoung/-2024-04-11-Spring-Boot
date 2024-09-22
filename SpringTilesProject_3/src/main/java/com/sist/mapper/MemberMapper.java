package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface MemberMapper {
	//id존재여부 확인
	@Select("SELECT COUNT(*) FROM member"
			+ "WHERE id=#{id}")
	public int memberIdCount(String id);
	//pwd 검색
	@Select("SELECT pwd, id, name, admin FROM member")
	public MemberVO memberGetPassword(String id);
}
