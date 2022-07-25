package com.edu.operator.test;
/*
 * Local과 Field 변수의 차이점
 * 
 * 				선언된 위치				기본 값 유무					메모리 위치				별칭
 * 
 * filed		메소드 바깥				있다							힙						멤버변수
 * 
 * local		메소드 블록 안				없다(사용 전 반드시 초기화)		스택						지역변수, Temporary V, Automatically V
 */
public class OperatorTest {

	public static void main(String[] args) {
		//Local 변수
		int i = 5;
		int j = 3;
		
		System.out.println(i==j);
		System.out.println(i!=j);
		System.out.println("====================");
		System.out.println("연산자 : "+i%j);
		System.out.println("연산자 : "+i/j);
		
		int k = 10;
		System.out.println(k++); // 10
		System.out.println(k);
		
		int m = 10;
		System.out.println(++m);
		System.out.println(m);
		
		
		
	}
	//i = 50;

}