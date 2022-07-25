package com.edu.jdbc.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * Test2의 문제점
 * 1. 서버정보가 프로그램에 하드코딩 되어져 있다. ==> public static final 상수
 * 2. Connection을 열어서 사용한 후 close를 안하고 있다. ==> finally 구문에서 반드시...!
 * 
 */

public class dbConnectionTest3 {
	// 메타데이터화 시켜야함
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	public static final String USER = "";
	public static final String PASS = ""; 
	
	public dbConnectionTest3() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1. 드라이버 로딩...
			Class.forName(DRIVER_NAME);
			System.out.println("드라이버 로딩 성공");
			
			//2. DB 서버와 연결
			conn = DriverManager.getConnection(URL, USER, PASS); // 커넥션은 사용하고 이후에 무조건무조건ㅁ조건 닫아야함
			System.out.println("DB서버 연결 성공");
			
			//3. PreparedStatement 객체 생성
			String query = "SELECT id, name, addr FROM custom";
			ps = conn.prepareStatement(query);
			System.out.println("3. PrepareStatement 생성....");
			
			rs = ps.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt("id")+"   "+
									rs.getString("name")+"  "+
									rs.getString("addr"));
			}
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}

	public static void main(String[] args) throws Exception{
		new dbConnectionTest3();

	}

}
;