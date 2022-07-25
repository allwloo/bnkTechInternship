package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * JDBC 4단계
 * 1. 클라이언트 메모리에 드라이버 로딩
 * 		드라이버 정보의 암축파일이 디폴트 클래스 패스로 잡혀져 있어야 한다.
 * 		EXT 디렉토리.
 * 
 * 	Class.forName("드라이버이름");
 * 
 * 2. DB서버와 연결 성공하면 Connection 객체 생성
 * 		Connection conn = DriverManager.getConnection(url, user, pw)
 * 
 * 
 * 
 * 3. preparedStatement 객체 생성
 * 		PreparedStatement ps = conn.prepareStatement(sql);
 * 
 * 4. Query문 실행
 * 		ResultSet rs = ps.excuteQuery()
 * 		int row = st.executeUpdate()
 * 		
 */
public class dbConnectionTest2 {
	
	public dbConnectionTest2() {
		try {
			//1. 드라이버 로딩...
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			//2. DB 서버와 연결
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			Connection conn = DriverManager.getConnection(url, "hr", "hr"); // 커넥션은 사용하고 이후에 무조건무조건ㅁ조건 닫아야함
			System.out.println("DB서버 연결 성공");
			
			//3. PreparedStatement 객체 생성
			
			PreparedStatement st = conn.prepareStatement(query);
			System.out.println("3. PrepareStatement 생성....");
			
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt("id")+"   "+
									rs.getString("name")+"  "+
									rs.getString("addr"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB서버 연결 실패");
		}
	}

	public static void main(String[] args) throws Exception{
		new dbConnectionTest2();

	}

}
;