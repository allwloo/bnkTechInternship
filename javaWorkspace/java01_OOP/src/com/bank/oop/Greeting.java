package com.bank.oop;
/*
 * 
 * Greeting
 * Ư���� ��󿡰� �λ��� ����ϴ� ����� ����ϴ� Ŭ����
 * "Ŭ������ �ʵ�� �޼ҵ�� �����Ǿ��� �ִ�."
 * :: ���� 2���� ��� �ϳ��� ���;��Ѵ�.
 * ���� ����� --> ����Ÿ�� + ���� �̸�;
 * String who;
 * String greet;
 * 
 * ���(�޼ҵ�)����
 * sayHello()
 */
public class Greeting {
	//1.	�ʵ� ����
	public String who;
	public String greet;
	
	//2.	�޼ҵ� ����
	public void sayHello()
	{
		//�ش� �޼ҵ尡 �ϴ� ����� ���� �ۼ�. �ֿܼ� ���
		System.out.println(who+",  "+greet);
	}
	
}