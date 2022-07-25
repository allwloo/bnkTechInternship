package com.edu.self.vo.parent;

import com.edu.self.util.MyDate;

public class Employee {
	
	private String name;
	private double salary;
	private MyDate birthDate;
	
	
	public Employee() {
		super();
		this.name = "홍길동";
		this.birthDate = new MyDate(1900,01,01);
		this.salary = 2000;
	}	
	
	public Employee(String name, MyDate birthDate, double salary) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
	}	
	
	public String getName() {
		return name;
	}
	
	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public MyDate getBirthDate() {
		return birthDate;
	}
	
	public String toString() { // -> 이거 오버라이드 사용
		return name+","+birthDate.getDate()+","+salary;
	}
	
}
