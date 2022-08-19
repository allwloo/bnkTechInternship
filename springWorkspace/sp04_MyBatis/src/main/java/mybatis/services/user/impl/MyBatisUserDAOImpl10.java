package mybatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;

public class MyBatisUserDAOImpl10 implements UserDAO {
	
	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "UserMapper10.";

	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::"+getClass().getName()+".setSqlSession() Call....");
		this.sqlSession = sqlSession;
	}

	@Override
	public int addUser(User user) throws Exception {
		int rows = sqlSession.insert("UserMapper10.addUser",user);
		sqlSession.commit();
		return rows;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int rows = sqlSession.delete("UserMapper10.removeUser",userId);
		sqlSession.commit();
		return rows;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int rows = sqlSession.delete("UserMapper10.updateUser",user);
		sqlSession.commit();
		return rows;
	}

	@Override
	public User getUser(String userId) throws Exception {
		User ruser = sqlSession.selectOne(MAPPER_NAME+"getUser",userId);
		return ruser;
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		List<User> ruser = sqlSession.selectList(MAPPER_NAME+"getUser",user);
		return ruser;
	}

}
