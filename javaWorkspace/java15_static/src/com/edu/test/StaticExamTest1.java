package com.edu.test;

class Car{
	int serialNumber;
	static int counter;
	
	Car(){
		counter++;
		serialNumber = counter;
	}
}

public class StaticExamTest1 {
	
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
		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = new Car();
		
		System.out.println("=================field===================");
		
		System.out.println(c1.serialNumber);
		System.out.println(c2.serialNumber);
		System.out.println(c3.serialNumber);
		
		System.out.println("=====================staitc======================");
		System.out.println(Car.counter);
		System.out.println(c1.counter);
		System.out.println(c2.counter);
		System.out.println(c3.counter);
		
		
		// 요걸 메모리로 설명~~~
	}

}