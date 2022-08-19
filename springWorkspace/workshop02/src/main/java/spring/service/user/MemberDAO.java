package spring.service.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import spring.service.domain.MemberVO;

public interface MemberDAO {
	//공통적인 로직...
	
	//비지니스 로직...
	void registerMember(MemberVO vo) throws SQLException;
	void deleteMember(String id)throws SQLException;
	void updateMember(MemberVO vo)throws SQLException;
	List<MemberVO> showAllMember() throws SQLException;
	MemberVO getMember(String id)throws SQLException;	
	boolean idExist(String id)throws SQLException;
	MemberVO login(String id, String pass)throws SQLException;
	
	
}



