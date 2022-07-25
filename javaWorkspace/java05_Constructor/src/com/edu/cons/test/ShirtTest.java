package com.edu.cons.test;

import com.edu.cons.Shirt;

public class ShirtTest {

	public static void main(String[] args) {
		Shirt t1 = new Shirt("nike",true,'L'); // 메모리에 클래스의 멤버가 올라간다.
		//객체 생성의 결과는 주소값. t1 - > 참조 변수
		System.out.println(t1.getBrand()+" "+t1.getSize());
	}

}
