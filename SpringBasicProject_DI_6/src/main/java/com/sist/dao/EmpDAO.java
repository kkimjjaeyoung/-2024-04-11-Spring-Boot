package com.sist.dao;

import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

//관계도 설정 : 스프링은 설정한 내용으로 설치
public class EmpDAO {
	private EmpMapper mapper;		//스프링으로부터 구현된 클래스 수령

	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}

}
