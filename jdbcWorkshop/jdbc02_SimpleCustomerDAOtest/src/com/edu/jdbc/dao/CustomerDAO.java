package com.edu.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
/*
 * 드라이버 로딩
디비 연결...Connection 반환받고 -> 문제 냈습니다
Connection 함수 : getConnection를 가지고 있는 객체 DriverManager
PreparedStatement 객체...쿼리문 실행하는 기능을 얘가 가지고 있다.
값 바인딩...쿼리문 실행
int executeUpdate() ---> INSERT/UODATE/DELETE (DML)
ResultSet executeQuery() --> SELECT
자원을 닫는다.
(열은 순서 반대로 닫아준다)
ResultSet --> PreparedStatement --> connection을 close()
 */

/*
 * 비즈니스 로직 마다마다
 * 1. 고정적인 로직... static code
 */
public class CustomerDAO {

    public CustomerDAO() throws ClassNotFoundException{
    	System.out.println("DAO Creating....");
  
    }
    
    public Connection getConnect() throws SQLException{
    	Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASS);
    	System.out.println("DB Server Connection.....");
    	return conn;
    }
    /*
     * INSERT,DELETE,UPDATE..... 2개 Connection, PreparedStatement
     * SELECT....... 3개 Connection, PreparedStatement, ResultSet
     */
    
    public void closeAll(Connection conn, PreparedStatement ps)throws SQLException{
    	if(ps!=null) ps.close();
    	if(conn!=null) conn.close();
    }
    public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs)throws SQLException{
    	if(rs!=null) rs.close();
    	closeAll(conn,ps);
    }

    public void addCustomer(int ssn, String name, String address) throws SQLException {
    	
    	String query = "INSERT INTO customer (ssn, name, address) VALUES(?,?,?)";
    	Connection conn = null;
    	PreparedStatement ps = null;
    	try {
    		conn = getConnect();
	    	ps = conn.prepareStatement(query);
	    	
	    	ps.setInt(1, ssn);
	    	ps.setString(2, name);
	    	ps.setString(3, address);
	    	
	    	System.out.println(name+" 님 "+ps.executeUpdate()+"명 회원등록 성공!! ");
    	}finally {
    		closeAll(conn, ps);
    	} 
    	
    }
    public void deleteCustomer(int ssn) throws SQLException {
    	
    	 String query = "DELETE FROM customer WHERE ssn=?";
    	 Connection conn = null;
    	 PreparedStatement ps = null;
    	 try {
     		conn = getConnect();
 	    	ps = conn.prepareStatement(query);
 	    	ps.setInt(1, ssn);
 	        System.out.println(ps.executeUpdate()+" 명 회원탈퇴 성공!! ");
 	    	
     	}finally {
     		closeAll(conn, ps);
     	} 
    }
    public void updateCustomer(int ssn, String name, String address)  throws SQLException {
    	Connection conn = null;
    	PreparedStatement ps = null;
    	try {
    		conn = getConnect();
    		String query = "UPDATE customer SET name =?, address=? WHERE ssn=?";
    		ps = conn.prepareStatement(query);
    		
    		ps.setString(1, name);
    		ps.setString(2, address);
    		ps.setInt(3, ssn);
    		
    		System.out.println(ps.executeUpdate()+"명 수정 성공");
    	}finally{
    		closeAll(conn,ps);
    	}
    }
    //select
    public void printAllCustomer() throws SQLException {
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
    		conn = getConnect();
    		String query = "SELECT * FROM customer";
    		ps = conn.prepareStatement(query);
    		
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			System.out.println(rs.getInt(1)+"   "+
    								rs.getString(2)+"   "+
    								rs.getString(3));
    		}
    		
    	}finally {
    		closeAll(conn,ps,rs);
    	}
    }
}