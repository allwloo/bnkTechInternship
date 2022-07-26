package com.deu.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.deu.jdbc.exception.DuplicateSsnException;
import com.deu.jdbc.exception.RecordNotFoundException;
import com.deu.jdbc.vo.Customer;

public interface CustomerDAO {
	//공통적인 기능의 Templete
	Connection getConnect() throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps)throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps, ResultSet rs)throws SQLException;
	
	
	//Business Logic Template...
	void registerCustomer(Customer vo) throws SQLException, DuplicateSsnException;
	void removeCustomer(int ssn)throws SQLException, RecordNotFoundException;
	void updateCustomer(Customer vo)throws SQLException, RecordNotFoundException;
	
	Customer getCustomer(int ssn) throws SQLException, RecordNotFoundException;
	ArrayList<Customer> getCustomer()throws SQLException;
	ArrayList<Customer> getCustomer(String address)throws SQLException;
	
	int getCountByAddress(String address) throws SQLException;
}
