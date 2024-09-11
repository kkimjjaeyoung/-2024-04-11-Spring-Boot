package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;

	//목록
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}
	
	//상세보기
	public EmpVO emp_detailData(int empno) {
		return mapper.emp_detailData(empno);
	}

}
