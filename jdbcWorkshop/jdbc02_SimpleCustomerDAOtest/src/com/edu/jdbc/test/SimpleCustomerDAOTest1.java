package com.edu.jdbc.test;

import java.sql.SQLException;

import com.edu.jdbc.dao.CustomerDAO;

public class SimpleCustomerDAOTest1{

	public static void main(String[] args) throws ClassNotFoundException {
		CustomerDAO dao = new CustomerDAO();
		try{
			dao.deleteCustomer(444);
			dao.addCustomer(444, "James", "NY");
			dao.updateCustomer(444, "Jacop", "NY");
			dao.printAllCustomer();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
	} // main

	//static initialization block...
	static {
		try {
	        Class.forName(ServerInfo.DRIVER_NAME);
	        System.out.println("드라이버 로딩 성공...");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		
	}
}
