package spring.service.user.impl;

/*
 * DataSource방식으로 디비 연결하기..
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;

public class MemberDAOImpl implements MemberDAO{
	
	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "MemberMapper.";

	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::"+getClass().getName()+".setSqlSession() Call....");
		this.sqlSession = sqlSession;
	}
	

	@Override
	public void registerMember(MemberVO vo) throws SQLException {		
		sqlSession.insert(MAPPER_NAME+"registerMember",vo);
		sqlSession.commit();
		System.out.println("멤버 추가 완료...!");
	}
	
	public void deleteMember(String id) throws SQLException {		
		sqlSession.insert(MAPPER_NAME+"deleteMember",id);
		sqlSession.commit();
		System.out.println("멤버 삭제 완료...!");
	}
	
	public void updateMember(MemberVO vo) throws SQLException {		
		sqlSession.insert(MAPPER_NAME+"updateMember",vo);
		sqlSession.commit();
		System.out.println("멤버 수정 완료...!");
	}
	

	@Override
	public List<MemberVO> showAllMember() throws SQLException {
		return sqlSession.selectList(MAPPER_NAME+"showAllMember");
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		return sqlSession.selectOne(MAPPER_NAME+"getMember",id);
	}
	
	public boolean idExist(String id) throws SQLException{
		if(sqlSession.selectOne(MAPPER_NAME+"idExist",id)!=null)
			return true;
		else
			return false;
	}
	
	@Override
	public MemberVO login(String id,String pass) throws SQLException {
		
		MemberVO rvo = getMember(id);
		
		if(rvo.getPassword().equals(pass))
			return rvo;
		else
			return null;
	
	}
	
		
	}	

