package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAOImpl implements ProductDAO {

	
	private DataSource ds;//JNDI(NAMING)서비스로 찾아온다.
	
	private static ProductDAOImpl dao = new ProductDAOImpl();

	private ProductDAOImpl() {
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
	public static ProductDAOImpl getInstacne() {
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
	public int registerProduct(ProductVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int pro_id = 0;
		try{
			conn=  getConnection();
			String query = "SELECT PRO_ID.NEXTVAL from dual";
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				pro_id = rs.getInt(1);
			
			
			query = "INSERT INTO product VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성됨...registerMember");
			
			ps.setInt(1, pro_id);
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getPrice());
			ps.setString(4, vo.getDetail());
			
			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		}finally{
			closeAll(ps, conn);
		}
		return pro_id;
	}

	@Override
	public ArrayList<ProductVO> showAllProduct() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProductVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT id, name, price, detail FROM product";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement....showAllProduct()..");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ProductVO(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("price"), 
						rs.getString("detail")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	// 단일 품목을 출력할때 저장한 객체를 바로 불러오기 때문에 사용하지 않습니다.
	@Override
	public ProductVO findByIdProduct(int pronum) throws SQLException {
		ProductVO vo = null;
		/*
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			//
			String query = "SELECT pronum, name, price, detail FROM product WHERE pronum=?";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement....findByIdProduuct()..");
			
			ps.setInt(1,pronum);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo =  new ProductVO(pronum, 
								   rs.getString("name"), 
								   rs.getString("price"),
								   rs.getString("detail"));
			}
		}finally{
			closeAll(rs, ps, conn);
		}*/
		return vo;
	}
	
}
