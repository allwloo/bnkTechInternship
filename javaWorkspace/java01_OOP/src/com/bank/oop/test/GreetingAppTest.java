package com.bank.oop.test;

import com.bank.oop.Greeting;

/*
 * 			OOP
 * 			
 * 		Obejct Oriented Class		|		~~ Test
 * 
 * 		��ü�� �ǹ��ϴ� Ŭ����		    |		��ü�� �ƴ�
 * 											���� Object Ŭ������ ��ü ��ü�� ������ִ� ���� Ŭ����
 * 
 */
public class GreetingAppTest {

	public static void main(String[] args) { // main method..���� �޼ҵ�
		//"��ü ���� == �޸𸮿� Ŭ������ ������� �� �ø���. == ����� �����Ϸ���"
		//
		Greeting hello = new Greeting();
		/*
		 * ����
		 * �ʵ�	--> �� �Ҵ�
		 * �޼ҵ�	--> �޼ҵ带 ȣ��
		 */
		hello.who = "�����ο�~~";
		hello.greet = "������ �ð��Դϴ�~~~�������̾��";
		
		hello.sayHello();

	}

}
