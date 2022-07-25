package com.edu.parent;

import com.edu.util.MyDate;
/*
 * Overloading
 * Method Overloading
 * Constructor Overloading
 */

public class Employee {
	private String name;
	private double salary;
	private MyDate birthday;
	
	public static final double BASIC_SALARY = 100;
	public static final String BASIC_NAME = "홍길동";
	
	public Employee() {}
	public Employee(String name, double salary, MyDate birthday) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthday = birthday;
	}
	public Employee(String name, MyDate birthday) {
		this(name, BASIC_SALARY , birthday);
	}
	public Employee(double salary, MyDate birthday) {
		this(BASIC_NAME , salary , birthday); // 생성자 앞에 붙은 this는 이 클래스 안에 있는 또다른 생성자를 찾아간다.
	}
	
	public String getDetails() {
		return name+"\t"+salary+"\t"+birthday.toString();
	}
	
	
}
