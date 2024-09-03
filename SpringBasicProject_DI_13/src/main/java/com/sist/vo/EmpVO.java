package com.sist.vo;

import java.util.Date;

public class EmpVO {
	private int empno,sal;
	private String ename, job, dbday;
	private Date hiredate;
	private DeptVO dvo=new DeptVO();
	private SalGradeVO svo=new SalGradeVO();
}
