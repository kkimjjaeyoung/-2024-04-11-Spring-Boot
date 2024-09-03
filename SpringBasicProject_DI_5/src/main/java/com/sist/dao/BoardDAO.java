package com.sist.dao;

import org.springframework.stereotype.Repository;

//<bean id="dao" class="com.sist.dao.BoardDAO"
@Repository("dao")
public class BoardDAO {
	public void list() {
		System.out.println("select 문장 수행");
	}
}
