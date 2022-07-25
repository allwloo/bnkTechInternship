package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class dbConnectionTest1 {
	
	public dbConnectionTest1() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			//2. DB 서버와 연결
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			Connection conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("DB서버 연결 성공");
			// 쿼리문을 실행하는 메소드는 PrepareStatement 객체가 갖고 있다. ******
			//executeUpdate() ----> DML을 실행할때, 리턴값 int 잘됐냐 잘 안됐냐
			//executeQuery() ----> SELECT를 실행할때 , 리턴값 ResultSet 데이터를 가져온다
			//문제 어떻게 나오냐면요 DML 쿼리문을 실행하는 메소드는요? 리턴값은요?
			// SELECT문을 실행할때는? excuteQuery()
			//3. PreparedStatement 객체 생성
			/*
			String query = "INSERT INTO custom (id, name, addr) VALUES(?,?,?) ";
			PreparedStatement st = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성");
			
			//4. ?에 대한 값을 바인딩
			st.setInt(1, 333);
			st.setString(2, "구자겸");
			st.setString(3, "신림동");
			
			System.out.println(st.executeUpdate()+" row INSERT ok~~!");*/
			
			//delete...333에 해당하는 구자겸씨를 삭제
//			String query = "DELETE FROM custom WHERE id=?";
//			st.setInt(1, 333);
		
			
			//update...id가 111인 고개그이 이름을 염미정 수정, addr을 산포시로 수정
//			String query = "UPDATE custom SET addr =  ? , name = ? WHERE id = ?";
//			PreparedStatement st = conn.prepareStatement(query);
//			st.setString(1, "산포시");
//			st.setString(2, "염미정");
//			st.setInt(3, 111);
			
			String query = "INSERT INTO custom(id,name,addr) VALUES(?,?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1,  333);
			st.setString(2,  "구자경");
			st.setString(3, "구로시");
			
			
			
			System.out.println(st.executeUpdate());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB서버 연결 실패");
		}
	}

	public static void main(String[] args) throws Exception{
		new dbConnectionTest1();

	}

}
;