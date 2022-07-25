package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class EmployeePolyTest1 {

	public static void main(String[] args) {
		Employee e = new Employee("구자경", 2000000, "역삼동",new MyDate(1999, 1, 3));
		Manager m =  new Manager("염미정", 2400000, "문현동", new MyDate(2000, 2, 12), "개발부");
		Engineer eg = new Engineer("염창희", 3500000, "대연동", new MyDate(1999,11,14), "자바", 300);
		
		System.out.println(e.getDetails());
		System.out.println(m.getDetails());
		System.out.println(eg.getDetails());
		
		////////////////////////////////////////////////////////////////////////////
		
		/*
		 * PolyMorphism
		 * ::
		 * 문제, 냈습니다! 주관식으로 냈습니다
		 * 답을 쓰실때는요 철자 안틀리도록 (다형성)이라고 써주시면 될 것 같아요
		 * 부모타입으로 자식객체를 생성하는 것
		 * 우리들이 정리해야할 것
		 * 1) Manager m = new Manager()
		 * 			VS 차이점 짚기
		 * 2) Employee m1 = new Manager()
		 * 
		 * 
		 * 
		 */
	/*
	 * Virtual Method Invocation 원리
	 * 실제가 아니라 가상 메소드가 호출된다는 말
	 * 
	 * compile type	-	부모의 메소드 호출
	 * Runtime type -	생성된 실질적인 자식의 메소드를 호출
	 * 상속관계에서 오버라이딩 된 자식의 메소드에서 발생한다.
	 * 
	 */
		System.out.println("============================================ ");
		Employee m1 =  new Manager("염미정", 2400000, "문현동", new MyDate(2000, 2, 12), "개발부");
		Employee eg1 = new Engineer("염창희", 3500000, "대연동", new MyDate(1999,11,14), "자바", 300);
		
		//오브젝트 캐스팅
		/*
		 * Object Casting
		 * 부모타입에 없는 자식만의 멤버를 호출할때 발생
		 * 자식타입으로 Casting하고 나서 자식의 타입으로 다시 찾아야 한다.
		 */
		((Manager) m1).changeDept("AI분석부");
//		Manager manager = (Manager)m1;
//		manager.changeDept("AI분석부");
		System.out.println(m1.getDetails());
		System.out.println(eg1.getDetails());
		
		
	}

}












