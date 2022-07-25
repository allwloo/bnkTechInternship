package com.edu.test;

class A{
	public final static int BASIC_SALARY = 3000000;
	public final String test() {
		return "오버라이딩 금지";
	}
}

final class B{//상속금지
	
}

class D extends A{
//	public final String test() {
//		return "오버라이딩 금지";
//	}
}
public class StaticExamTest3 {
	
	/*
	 * static 성질
	 * 1. static으로 지정된 멤버는 객체 생성 과정 없이 메모리에 올라간다.
	 * 2. class 파일이 로더되는 시점에 메모리에 로더된다.
	 * 3. static이 붙은 변수는 로컬레벨에서 사용될 수 없다.
	 * 4. static으로 지정된 변수들은 생성된 객체들이 모두 공유한다!!!
	 * 		필드 VS 				로컬변수 VS 					클래스변수(static) 정확하게 구분
	 * 5. static 키워드와 항상 붙어서 같이  쓰이는 키워드 : final ---- usage Modifier
	 * 	
	 * 		final static
	 * 		final ---> 내가 마지막이야~
	 * 		final + 변수 : "내가 마지막 변수야~~" --> 상수의미
	 * 		final + 메소드 : "내가 마지막 메소드야~~" --> 오버라이드 금지
	 * 		final + 클래스 : "내가 마지막 클래스야~~" --> 상속 금지 """"*** 문제 나옵니다.
	 * 
	 * 		
	 * 6. 싱글톤
	 * 
	 * <ㅡㅡㅡㅡㅡㅡ ㅡ주관식 문제(static)ㅡㅡㅡㅡㅡㅡㅡㅡ>
	 * 자바 실행 파일이 동작하는 메모리 장소 "JVM" <<<< 이것도 시험
	 * 
	 */
	public static void main(String[] args) {

	}

}
