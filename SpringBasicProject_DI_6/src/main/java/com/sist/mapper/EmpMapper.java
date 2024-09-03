package com.sist.mapper;

import java.util.*;
import lombok.Setter;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.EmpVO;

public class EmpMapper {
	@Select("SELECT empno, ename, job, hiredate, sal FROM emp ORDER BY empno ASC")
	public List<EmpVO> empListData();
	//resultType 	id		parameterType
	
}
