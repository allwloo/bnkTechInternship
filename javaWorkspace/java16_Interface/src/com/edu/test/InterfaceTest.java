package com.edu.test;

//추상메소드 구현부가 없는 메소드
//기능의 Template 
// field가 없다
//추상이기 때문에... 객체 생성의 대상이 될 수 없다. Type으로만 존재
interface Flyer{
	void fly();//public abstract
	public abstract void land();
	void take_off(int a, int b);
}
class Bird implements Flyer{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("새가 난다");
	}

	@Override
	public void land() {
		// TODO Auto-generated method stub
		System.out.println("새가 착륙");
	}

	@Override
	public void take_off(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("새가 난단");
	}
	
}
public class InterfaceTest {

	public static void main(String[] args) {
		Flyer f = new Bird();

	}

}
