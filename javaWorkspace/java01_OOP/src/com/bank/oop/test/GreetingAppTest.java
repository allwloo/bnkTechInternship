package com.bank.oop.test;

import com.bank.oop.Greeting;

/*
 * 			OOP
 * 			
 * 		Obejct Oriented Class		|		~~ Test
 * 
 * 		객체를 의미하는 클래스		    |		객체가 아님
 * 											앞의 Object 클래스를 실체 객체로 만들어주는 실행 클래스
 * 
 */
public class GreetingAppTest {

	public static void main(String[] args) { // main method..실행 메소드
		//"객체 생성 == 메모리에 클래스의 멤버들을 다 올린다. == 멤버에 접근하려고"
		//
		Greeting hello = new Greeting();
		/*
		 * 접근
		 * 필드	--> 값 할당
		 * 메소드	--> 메소드를 호출
		 */
		hello.who = "여러부운~~";
		hello.greet = "마지막 시간입니다~~~수고많으셨어요";
		
		hello.sayHello();

	}

}
