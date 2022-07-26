package com.edu.jdbc.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * 상수값으로 서버 정보를 지정했지만 더 나은 방식은 완전히 프로그램과 분리시키는 것이다.
 * 다시말해서 서버의 파편적인 정보를 "Meta Data화" 시키겠다.
 * -->인터페이스 적용
 * 
 */

import config.ServerInfo;
import sql.QueryInfo;

public class CustomerJDBCTest {
	
	public CustomerJDBCTest() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		try {
			//1. 드라이버 로딩...
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공");
			
			//2. DB 서버와 연결
			conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS); // 커넥션은 사용하고 이후에 무조건무조건ㅁ조건 닫아야함
			System.out.println("DB서버 연결 성공");
			
			//3. PreparedStatement 객체 생성
			ps = conn.prepareStatement(QueryInfo.queryInsert);
			System.out.println("3. PrepareStatement 생성....");
			
			ps.setInt(1, 221);
			ps.setString(2, "김근영");
			ps.setString(3, "연제구");
			System.out.println("실행 처리코드: "+ps.executeUpdate());

			System.out.println("=========");
			
			ps2 = conn.prepareStatement(QueryInfo.querySelect);
			System.out.println("SELECT Prepare 생성....");
			rs = ps2.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("ssn")+"   "+
									rs.getString("name")+"  "+
									rs.getString("address"));
				
			System.out.println("==========================");
			}
		} finally {
			System.out.println("종료되었습니다.");
			rs.close();
			ps2.close();
			ps.close();
			conn.close();
		}
	}

	public static void main(String[] args) throws Exception{
		new CustomerJDBCTest();

	}

}
;