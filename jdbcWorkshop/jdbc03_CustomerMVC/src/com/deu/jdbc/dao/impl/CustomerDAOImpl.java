package com.deu.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.deu.jdbc.dao.CustomerDAO;
import com.deu.jdbc.exception.DuplicateSsnException;
import com.deu.jdbc.exception.RecordNotFoundException;
import com.deu.jdbc.vo.Customer;

import config.ServerInfo;

public class CustomerDAOImpl implements CustomerDAO{

	private static CustomerDAOImpl dao = new CustomerDAOImpl();
	private CustomerDAOImpl() {
		System.out.println("싱글톤 패턴 생성");
	}
	public static CustomerDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASS);
		System.out.println("DB Server Coonection...");
		return conn;
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
		
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		if(rs!=null) rs.close();
		closeAll(conn,ps);
	}

	
	
	// 동일한 사람이 있는지 없는지 판단 
	// SELECT ssn FROM customer WHERE ssn=?
	private boolean ssnExist(int ssn, Connection conn) throws SQLException{ // conn 인자로 넣어서 고치기
		String query = "SELECT ssn FROM customer WHERE ssn=?";
		PreparedStatement ps = null;
		ResultSet rs = null;

		ps = conn.prepareStatement(query);
		ps.setInt(1, ssn);
		rs = ps.executeQuery();
		
		return rs.next();
	}
	
	@Override
	public void registerCustomer(Customer vo) throws SQLException, DuplicateSsnException {
		
		String query = "INSERT INTO customer (ssn, cust_name, address) VALUES(?,?,?)";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		
		try {
			if(!ssnExist(vo.getSsn(), conn)) {
				ps.setInt(1, vo.getSsn());
				ps.setString(2, vo.getCustName());
				ps.setString(3, vo.getAddress());
				System.out.println(ps.executeUpdate()+"명 회원가입 하였습니다");
			}else {
				 throw new DuplicateSsnException("이미 생성된 계정입니다.");
			}
		}finally {
			closeAll(conn,ps);
		}
		
	}
	// SELECT ssn FROM customer WHERE ssn=?
	@Override 
	public void removeCustomer(int ssn) throws SQLException, RecordNotFoundException { // 작성 완료
		
		String query = "DELETE FROM customer WHERE ssn = ?";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		
		try {
			if(ssnExist(ssn, conn)) {
				ps.setInt(1,  ssn);
				System.out.println(ps.executeUpdate()+"명 탈퇴 완료했습니다.");
			}
			else {
				throw new RecordNotFoundException("삭제할 대상이 존재하지 않습니다.");
			}
		}finally {
			closeAll(conn,ps);
		}
		
	}
	// SELECT ssn FROM customer WHERE ssn=? ssnE그지스트
	@Override
	public void updateCustomer(Customer vo) throws SQLException, RecordNotFoundException {
		
		String query = "UPDATE customer SET cust_name = ?, address = ? WHERE ssn = ? ";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		
		try {
			if(ssnExist(vo.getSsn(),conn)) {
				ps = conn.prepareStatement(query);
				ps.setString(1, vo.getCustName());
				ps.setString(2, vo.getAddress());
				ps.setInt(3, vo.getSsn());
				System.out.println(ps.executeUpdate()+"명 회원 정보 수정 완료했습니다.");
			}else {
				 throw new RecordNotFoundException();
			}
		}finally {
			closeAll(conn,ps);
		}
	}

	@Override
	public Customer getCustomer(int ssn) throws SQLException, RecordNotFoundException{
		
		String query = "SELECT ssn, cust_name, address FROM customer WHERE ssn = ?";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = null;
		Customer cust = new Customer(ssn);
		
		try {
			if(ssnExist(ssn, conn)){
				ps.setInt(1, ssn);
				rs = ps.executeQuery();
				while(rs.next()) {
					cust.setSsn(rs.getInt(1));
					cust.setCustName(rs.getString(2));
					cust.setAddress(rs.getString(3));
				}
			}else {
				throw new RecordNotFoundException();
			}
		}finally {
			closeAll(conn,ps,rs);
		}
		
		return cust;
	}

	@Override
	public ArrayList<Customer> getCustomer() throws SQLException {
		
		String query = "SELECT ssn, cust_name, address FROM customer";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = null;
		ArrayList<Customer> custs = new ArrayList<Customer>();
		
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				custs.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		}finally {
			closeAll(conn,ps,rs);
		}
		
		return custs;
	}

	@Override
	public ArrayList<Customer> getCustomer(String address) throws SQLException {
		
		String query = "SELECT ssn, cust_name, address FROM customer WHERE address = ?";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = null;
		ArrayList<Customer> custs = new ArrayList<Customer>();
		
		try {
			ps.setString(1, address);
			rs = ps.executeQuery();
			while(rs.next()) {
				custs.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		}finally {
			closeAll(conn,ps,rs);
		}
		
		return custs;
	}

	@Override
	public int getCountByAddress(String address) throws SQLException {
		
		String query = "SELECT ssn, cust_name, address FROM customer WHERE address = ?";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = null;
		int count = 0;
	
		try {
			ps.setString(1, address);
			rs = ps.executeQuery();
			while(rs.next()) {
				count++;
			}
		}finally {
			closeAll(conn,ps,rs);
		}
		
		return count;
	}
	
}
