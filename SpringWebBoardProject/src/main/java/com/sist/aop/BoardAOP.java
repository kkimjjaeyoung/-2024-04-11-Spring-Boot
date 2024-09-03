package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//공통모듈

@Aspect		//메모리 할당을 하는 어노테이션이 아님(<aop:aspect>)
@Component
public class BoardAOP {
	@Around("execution(*com.sist.web.*Controller.*(..))")
	public Object logfile(ProceedingJoinPoint jp) {
		Object obj=null;
		try {
			long start=System.currentTimeMillis();
			obj=jp.proceed();
			System.out.println("요청메소드:"+jp.getSignature().getName());
			long end=System.currentTimeMillis();
			System.out.println("요청소요시간"+(end-start));
		}catch (Throwable ex) {	//exception보다 큰범위
			// TODO: handle exception
		}
		return obj;
	}
}
