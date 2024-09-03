package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;

public class EmpMapper {
	@Select("SELECT empno, ename, job, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, sal"
			+ "FROM emp ORDER BY empno ASC")
	public List<EmpVO> empListData();
}
