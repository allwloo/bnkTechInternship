package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.InvalidTransactionException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;
/*
 * 싱글톤 사용 X ---- 원래는 싱글톤 패턴으로 작성하는게 맞다.
 */
public class Database implements DatabaseTemplate{
	
	public Database(String serverIp) throws ClassNotFoundException{
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩 성공..");
	}
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn =DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("Database Connection......");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();			
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);			
	}
	
	//ssn이 있는지 없는지 확인하는 기능....하나 추가...isIsbn()과 동일한 기능
	public boolean isExist(String ssn, Connection conn)throws SQLException{
		String sql ="SELECT ssn FROM customer WHERE ssn=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1,ssn);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}

	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			if(!isExist(cust.getSsn(), conn)) { //추가하려는 고객의 ssn이 없다면...추가
				String query = "INSERT INTO customer (ssn, cust_name, address) VALUES(?,?,?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				
				System.out.println(ps.executeUpdate()+" 명 INSERT OK....addCustomer() ..");
			}else {
				throw new DuplicateSSNException();
			}			
		}finally {
			closeAll(ps, conn);
		}		
	}
//
	@Override
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if(isExist(ssn, conn)) {
				String query = "DELETE FROM customer WHERE ssn=?";
				ps = conn.prepareStatement(query);					
				
				ps.setString(1, ssn);		
				
				System.out.println(ps.executeUpdate()+" 명 DELETE OK...deleteCustomer()...");				
			}else {
				throw new RecordNotFoundException();
			}			
		}finally {
			closeAll(ps, conn);
		}		
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "UPDATE customer SET cust_name=?, address = ?  WHERE ssn=?";
			
			ps = conn.prepareStatement(query);
			ps.setString(1, cust.getName());
			ps.setString(2, cust.getAddress());
			ps.setString(3, cust.getSsn());
			
			int row = ps.executeUpdate();
			if(row==1) System.out.println(row+" 명 UPDATE OK...updateCustomer()..");
			else throw new RecordNotFoundException();
		}finally {
			closeAll(ps, conn);
		}		
	}

	// getPortpol 특정 사용자의 모든정보를 리턴~~~
	@Override
	public Vector<SharesRec> getPortfolio(String ssn) throws SQLException {
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 Vector<SharesRec> v = new Vector<SharesRec>();
		 
		 try{
			conn = getConnect();
			String query = "SELECT symbol, quantity FROM shares WHERE ssn = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+rs.getString(2));
			}

		 }finally {
			 closeAll(rs, ps, conn);
		 }
		return v;
	}
//특정한 고객의 모든 정보를 리턴하는 기능 포트폴리오가 있으니까 그 정보까지 리턴해줘야함
	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		CustomerRec cust = null;
		try {
			


			
		}finally {
			closeAll(rs, ps, conn);
		}
		return cust;
	}
	//모든 고객의 모든 정보를 리턴하는 기능
	@Override
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		ArrayList<CustomerRec> list = new ArrayList<>();
		try {
			



		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	// 모든 주식 반환
	@Override
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 ArrayList<StockRec> list = new ArrayList<StockRec>();
		 try{
			 conn = getConnect();
			 String query = "SELECT symbol, price FROM stock";
			 ps = conn.prepareStatement(query);
			 rs = ps.executeQuery();
			 while(rs.next()){
				 list.add(new StockRec(rs.getString(1), 
						 			   rs.getFloat(2)));
			 }
		 }finally{
			 closeAll(rs, ps, conn);
		 }
		 return list;
	}
/*
 * 누가 어떤 주식을 몇개 살지를 정의하는 기능...
 * 
 * 지금 가지고 있는 주식의 갯수(quantity)부터 확인해봐야 한다.
 * 
 * 내가 현재 주식을 안가지고 있다 0 , 100--> insert into  100
 * 내가 현재 어느정도의 주식을 가지고 있다 50, 100--> update 150
 */
	@Override
	
	public int isBuy(Connection conn, String ssn, String symbol) throws SQLException {
		
		String query = "SELECT quantity FROM shares WHERE ssn = ? and symbol = ?"; // 먼저 SELECT
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, ssn);
		ps.setString(2, symbol);
		ResultSet rs = ps.executeQuery();
		int quantity = 0;
		
		while(rs.next()) {
			quantity = rs.getInt(1);
		}
		
		return quantity;
	}
	
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException {
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 
		 
		 try {
			 
			 conn=  getConnect();;
			 isBuy(conn,ssn,symbol)
			 
			 if() { // 결과값이 있으면? UPDATE
				 String query = "UPDATE shares SET quantity = ? WHERE ssn = ? and symbol  ?";
				 ps = conn.prepareStatement(query);
				 ps.setInt(1,quantity);
				 ps.setString(2, ssn);
				 ps.setString(3, symbol);
				 System.out.println("UPDATE가 완료되었습니다. 주식 추가 구매 완료, 코드:"+ps.executeUpdate());
			 }else {// 결과값이 없으면? INSERT
				 String query = "INSERT INTO shares (ssn, symbol, quantity) VALUES(?,?,?)";
				 ps = conn.prepareStatement(query);
				 ps.setInt(3,quantity);
				 ps.setString(1, ssn);
				 ps.setString(2, symbol);
				 System.out.println("INSERT가 완료되었습니다. 주식 구매 완료"+ps.executeUpdate());
			 }
		 }finally {
			 closeAll(rs, ps, conn);
		 }
		
	}
/*
 * 누가 어떤 주식을 몇개 팔것인가에 대한 기능을 정의...
 * 현재 가지고 있는 주식의 수량을 먼저 알아야 한다....int q
 * 
 * 1) 100개를 가지고 있다 ---- 50  SELL --- update
 * 2) 100개를 가지고 있다 ---- 100 SELL --- delete
 * 3) 100개를 가지고 있다 ---- 200 SELL --- InvalidTransactionException 펑!! 
 * 4) 팔려는 주식이 없을때 				 --- RecordNotFoundException 펑!!
 */
	@Override
	public void sellShares(String ssn, String symbol, int quantity)
			throws SQLException, javax.transaction.InvalidTransactionException, RecordNotFoundException {
		 Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 try {


		 
		}finally {
		 	closeAll(rs, ps, conn);
		}
		
	}
	
	/*@Override
	public void sellShares(String ssn, String symbol, int quantity)
			throws SQLException, InvalidTransactionException, RecordNotFoundException {
		
		Connection conn = null;
		 PreparedStatement ps = null;	
		 ResultSet rs = null;
		 try {


		 
		}finally {
		 	closeAll(rs, ps, conn);
		}
	}*/
	
	
	
}






