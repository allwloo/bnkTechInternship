package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO{
	
	private DataSource ds;//JNDI(NAMING)서비스로 찾아온다.
	
	private static UserDAOImpl dao = new UserDAOImpl();

	private UserDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource look up success...");
		} catch (NamingException e) {
			System.out.println("DataSource look up fail...");
		}
	}
	public static UserDAOImpl getInstacne() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("디비연결 성공....");
		return ds.getConnection(); //Connection 하나씩 Pool에서 받아온다..
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}

	@Override
	public User login(String userId, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User vo = null;
		
		try{
			conn = getConnection();
			//
			String query = "SELECT userid, password, name, email FROM userinfo WHERE userid=? AND password=?";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement.... Login......");
			
			ps.setString(1,userId);
			ps.setString(2,password);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo =  new User(userId, 
								   rs.getString("password"), 
								   rs.getString("name"),
								   rs.getString("email"));
			}
			}finally{
				closeAll(rs, ps, conn);
			}
		return vo;
	}

}
