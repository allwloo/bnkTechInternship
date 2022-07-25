package com.edu.self.service;

import com.edu.self.vo.Engineer;
import com.edu.self.vo.Manager;
import com.edu.self.vo.parent.Employee;

public interface EmployeeService {

	
	public void addEmployee(Employee e);
	public void deleteEmployee(String name);
	public void updateEmployee(double salary, String dept, int deptno, String name);
	public void updateEmployee(double salary, String tech, double bonus, String name);
	public void updateEmployee(double salary, String name);
	public Employee[] findEmployee(Employee e); // 특정 Employee를 넣으면 그 부서(엔지니어,임플로이,매니저)를 모두 반환하도록 수정
	public Employee findEmployee(String name);
	public void printEmployee();
	
	public double calAnnualSalary(Employee e); // 추가 1(연봉 계산)
	public Employee[] findBirthDayMen( int month, int day); // 생일인사람~
	
	
}
