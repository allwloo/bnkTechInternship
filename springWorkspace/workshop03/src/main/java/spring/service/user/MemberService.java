package spring.service.user;

import java.sql.SQLException;
import java.util.List;

import spring.service.domain.MemberVO;

public interface MemberService {

	
	void registerMember(MemberVO vo) throws SQLException;
	void updateMember(MemberVO vo)throws SQLException;
	List<MemberVO> showAllMember() throws SQLException;
	MemberVO getMember(String id)throws SQLException;	
	boolean idExist(String id)throws SQLException;
	MemberVO login(String id, String pass)throws SQLException;
	
}
