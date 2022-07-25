package com.edu.test;

class StaticExam{
	static String name = "홍길동"; // static v, class v, 전역 변수
	static int age = 19;
	int count = 1; // 멤버 변수
	
	//static은 static끼리 통한다
	public static void getMember() {
		System.out.println("우/윳/빛/깔"+name);
	}
	public void getMember2() {
		//static String address = "한남동";
		System.out.println("우/윳/빛/깔"+name);
	}
}



public class StaticExamTest2 {
	
	/*
	 * static 성질
	 * 1. static으로 지정된 멤버는 객체 생성 과정 없이 메모리에 올라간다.
	 * 2. class 파일이 로더되는 시점에 메모리에 로더된다.
	 * 3. static이 붙은 변수는 로컬레벨에서 사용될 수 없다.
	 * 4. static으로 지정된 변수들은 생성된 객체들이 모두 공유한다!!!
	 * 		필드 VS 				로컬변수 VS 					클래스변수(static) 정확하게 구분
	 * 5. static 키워드와 항상 붙어서 같이  쓰이는 키워드 : final ---- usage Modifier
	 * 
	 * 6. 싱글톤
	 * 
	 * <ㅡㅡㅡㅡㅡㅡ ㅡ주관식 문제(static)ㅡㅡㅡㅡㅡㅡㅡㅡ>
	 * 자바 실행 파일이 동작하는 메모리 장소 "JVM" <<<< 이것도 시험
	 * 
	 */
	public static void main(String[] args) {
		//static한 멤버를 사용할때는 클래스이름.static 멤버;
		StaticExam.getMember();
//		StaticExam.getMember2();
		StaticExam exam = new StaticExam();
		exam.getMember2();
		System.out.println("=========================================");
		exam.getMember();
		
	}

}
