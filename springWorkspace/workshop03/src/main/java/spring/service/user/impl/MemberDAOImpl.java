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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "MemberMapper.";

	@Override
	public void registerMember(MemberVO vo) throws SQLException {		
		sqlSession.insert(MAPPER_NAME+"registerMember",vo);
		System.out.println("멤버 추가 완료...!");
	}
	
	public void deleteMember(String id) throws SQLException {		
		sqlSession.insert(MAPPER_NAME+"deleteMember",id);
		System.out.println("멤버 삭제 완료...!");
	}
	
	public void updateMember(MemberVO vo) throws SQLException {		
		sqlSession.insert(MAPPER_NAME+"updateMember",vo);
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
		return sqlSession.selectOne(MAPPER_NAME+"getMember",new MemberVO(id,pass));
	}
	
		
	}	

