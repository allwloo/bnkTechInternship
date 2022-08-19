package spring.service.user.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;


@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		memberDAO.registerMember(vo);
	}

	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		memberDAO.updateMember(vo);
	}

	@Override
	public List<MemberVO> showAllMember() throws SQLException {
		return memberDAO.showAllMember();
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		return memberDAO.getMember(id);
	}

	@Override
	public boolean idExist(String id) throws SQLException {
		return memberDAO.idExist(id);
	}

	@Override
	public MemberVO login(String id, String pass) throws SQLException {
		return memberDAO.login(id, pass);
	}
	
}
