package com.deu.jdbc.test;

import java.sql.SQLException;
import java.util.ArrayList;

import com.deu.jdbc.dao.impl.CustomerDAOImpl;
import com.deu.jdbc.exception.RecordNotFoundException;
import com.deu.jdbc.vo.Customer;

import config.ServerInfo;

public class CustomerDAOUnitTest {

	public static void main(String[] args) {
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		Customer cst1 = new Customer(0,"우영우","수원시");
		ArrayList<Customer> custs = new ArrayList<Customer>();
		try {
			dao.registerCustomer(cst1);
			System.out.println(dao.getCustomer(0));
			custs = dao.getCustomer("수원시");
			System.out.println(custs);
			for(Customer c : custs) {
				System.out.println(c);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공...");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패...");
		}
	}

}
