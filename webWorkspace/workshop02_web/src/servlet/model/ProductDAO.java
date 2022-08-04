package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
	
	Connection getConnection() throws SQLException ;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException ;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException ;
	
	//비지니스 로직...
	int registerProduct(ProductVO vo) throws SQLException;
	ArrayList<ProductVO> showAllProduct() throws SQLException;
	ProductVO findByIdProduct(int pronum)throws SQLException;
}
