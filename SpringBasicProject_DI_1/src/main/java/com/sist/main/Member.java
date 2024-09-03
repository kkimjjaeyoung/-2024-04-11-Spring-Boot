package com.sist.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {
	private int mno;
	private String name;
	private String sex;
	private String address;
	private String phone;
	
	public Member(int mno, String name, String sex, String address, String phone) {
		super();
		this.mno = mno;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
	}

	public void print() {
		System.out.println("회원번호:"+mno);
		System.out.println("이름:"+name);
		System.out.println("성별:"+sex);
		System.out.println("주소:"+address);
		System.out.println("전화:"+phone);
	}
}
