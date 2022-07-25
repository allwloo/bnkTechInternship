package com.edu.self.test;

import com.edu.self.service.EmployeeServiceImpl;
import com.edu.self.util.MyDate;
import com.edu.self.vo.Engineer;
import com.edu.self.vo.Manager;
import com.edu.self.vo.parent.Employee;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		
		
		EmployeeServiceImpl service = EmployeeServiceImpl.getInstance(30); // 최대 수용 인원 30
		
		service.addEmployee(new Engineer("김근영", new MyDate(1998,01,21),2400,"c++",500));
		service.addEmployee(new Manager("이홍민", new MyDate(1998,04,15),2800,"기획재정부",1));
		service.addEmployee(new Employee("차욱진", new MyDate(1999,12,26),2000));
		
		System.out.println("=========printEmployee=============");
		service.printEmployee();
		
		
		System.out.println("========findEmployee========");
		Employee returnEp = service.findEmployee("이홍민");
		System.out.println(returnEp.toString());
		
		System.out.println("=======addEmployee======");
		
		service.addEmployee(new Employee("이성원", new MyDate(1999,12,21),2000));
		service.printEmployee();
		
		System.out.println("=======deleteEmployee======");
		service.deleteEmployee("이성원");
		service.printEmployee();
		
		System.out.println("========updateEmployee========");
		service.updateEmployee(3000,"자바",1000.0, "김근영");
		service.updateEmployee(3400,"대통령비서실",2, "이홍민");
		service.updateEmployee(2400,"차욱진");
		service.printEmployee();
		
		System.out.println("======findEmployees======");
		Employee[] returnEps = service.findEmployee(new Manager("이홍민", new MyDate(1998,04,15),2800,"기획재정부",1));
		for(Employee eps : returnEps) {
			if(eps == null) continue;
			System.out.println(eps.toString());
		}
		
		
		System.out.println("=======추가1========(연봉계산)");
		System.out.println(service.calAnnualSalary(new Manager("이홍민", new MyDate(1998,04,15),2800,"기획재정부",1)));
		System.out.println(service.calAnnualSalary(new Engineer("김근영", new MyDate(1998,01,21),2400,"c++",500)));
		
		System.out.println("=======추가2=======(오늘 생일인사람 구하기)");
		returnEps = service.findBirthDayMen(1, 21);
		for(Employee eps : returnEps) {
			if(eps == null) continue;
			System.out.println(eps);
		}
	}
		
}







