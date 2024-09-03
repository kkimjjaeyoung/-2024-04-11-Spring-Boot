package com.sist.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository("dao")
public class EmpDAO2 {
	private EmpMapper mapper;
	
	public void set mapper(EmpMapper ampper) {
		this.mapper=mapper;
	}
	
	
}
