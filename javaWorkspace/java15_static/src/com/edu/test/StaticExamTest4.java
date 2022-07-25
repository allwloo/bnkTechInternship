package com.edu.test;

class Service{
	private static Service service = new Service();
	private Service() {
		System.out.println("Singtone Pattern Ready....");
	}
	public static Service getInstance() {
		return service;
	}
}

public class StaticExamTest4 {
	
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
	 * 6. 싱글톤 ** 문제 냈습니다용
	 * 1) 일단 클래스안에서 하나의 객체는 생성
	 * 		private static 으로 객체를 하나 생성합니다
	 * 2) 다른 곳에서 해당 클래스로 객체생성 못하도록 막아둔다.
	 * 		private 생성자(){
	 * 3) 	public static Service getInstance(){
	 * 			return service e;
	 * 		}
	 * 
	 * <ㅡㅡㅡㅡㅡㅡ ㅡ주관식 문제(static)ㅡㅡㅡㅡㅡㅡㅡㅡ>
	 * 자바 실행 파일이 동작하는 메모리 장소 "JVM" <<<< 이것도 시험
	 * 
	 */
	

	
	public static void main(String[] args) {
		Service s1 = Service.getInstance();
		Service s2 = Service.getInstance();
		Service s3 = Service.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}
