package servlet.model;
/*
 * DataSource방식으로 디비 연결하기..
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAOImpl implements MemberDAO{
	
	private DataSource ds;//JNDI(NAMING)서비스로 찾아온다.
	
	private static MemberDAOImpl dao = new MemberDAOImpl();

	private MemberDAOImpl() {
		//Resoruce Factory에 담겨져있는 Connection을 하나씩 Rent해오는 로직을 작성
		//Naming을 위한 context객ㅊ부터 생성
		
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource look up success...");
		} catch (NamingException e) {
			System.out.println("DataSource look up fail...");
		}
	}
	public static MemberDAOImpl getInstacne() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {		
		System.out.println("디비연결 성공....");
		return ds.getConnection(); //Connection 하나씩 Pool에서 받아온다..
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{		
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}

	@Override
	public void registerMember(MemberVO vo) throws SQLException {		
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=  getConnection();
			String query = "INSERT INTO member VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성됨...registerMember");
			
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getAddress());
			
			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		}finally{
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT id, password, name, address FROM member";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement....showAllMember()..");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new MemberVO(
						rs.getString("id"), 
						rs.getString("password"), 
						rs.getString("name"), 
						rs.getString("address")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try{
			conn = getConnection();
			//
			String query = "SELECT id, password, name, address FROM member WHERE id=?";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement....findByIdMember()..");
			
			ps.setString(1,id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo =  new MemberVO(id, 
								   rs.getString("password"), 
								   rs.getString("name"),
								   rs.getString("address"));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	@Override
	public MemberVO login(String id, String pass) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO vo = null;
		
		
		try{
			conn = getConnection();
			//
			String query = "SELECT id, password, name, address FROM member WHERE id=? AND password=?";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement.... Login......");
			
			ps.setString(1,id);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo =  new MemberVO(id, 
								   rs.getString("password"), 
								   rs.getString("name"),
								   rs.getString("address"));
			}
			}finally{
				closeAll(rs, ps, conn);
			}
		return vo;
	
	}
	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "UPDATE member SET password=?, name=?, address=?, WHERE id=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, vo.getPassword());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getAddress());
			ps.setString(4, vo.getId());
			ps.executeUpdate();
		}finally{
			closeAll(ps,conn);
		}
		
	}	

//   일종의 dao 단위테스트	
//	public static void main(String[] args)throws Exception{
//		MemberDAOImpl dao=MemberDAOImpl.getInstance();
////		MemberVO VO=dao.findByIdMember("encore");
////		System.out.println(VO);
//		
//		ArrayList<MemberVO> list=dao.showAllMember();
//		System.out.println(list);
//	}
}

















