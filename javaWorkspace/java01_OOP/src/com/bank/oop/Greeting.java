package com.bank.oop;
/*
 * 
 * Greeting
 * 특정한 대상에게 인삿말을 출력하는 기능을 출력하는 클래스
 * "클래스는 필드와 메소드로 구성되어져 있다."
 * :: 변수 2개와 기능 하나가 나와야한다.
 * 변수 선언법 --> 변수타입 + 변수 이름;
 * String who;
 * String greet;
 * 
 * 기능(메소드)정의
 * sayHello()
 */
public class Greeting {
	//1.	필드 선언
	public String who;
	public String greet;
	
	//2.	메소드 정의
	public void sayHello()
	{
		//해당 메소드가 하는 기능을 직접 작성. 콘솔에 출력
		System.out.println(who+",  "+greet);
	}
	
}
