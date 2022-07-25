package com.edu.self.vo;

import com.edu.self.util.MyDate;
import com.edu.self.vo.parent.Employee;

public class Engineer extends Employee {
	private String tech;
	private double bonus;
	
	public Engineer(String name, MyDate birthDate, double salary, String tech, double bonus) {
		super(name, birthDate, salary);
		this.tech = tech;
		this.bonus = bonus;
	}	
	
	public void setTech(String tech) {
		this.tech = tech;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}	

	public String getTech() {
		return tech;
	}
	public double getBonus() {
		return bonus;
	}
	public String toString() {
		return super.toString()+","+tech+","+bonus;
	}	
}
