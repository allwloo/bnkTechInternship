package mybatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;

@Repository
public class MyBatisUserDAOImpl13 implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "UserMapper10.";

	@Override
	public int addUser(User user) throws Exception {
		int rows = sqlSession.insert("UserMapper10.addUser",user);
		return rows;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int rows = sqlSession.delete("UserMapper10.removeUser",userId);
		return rows;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int rows = sqlSession.delete("UserMapper10.updateUser",user);
		return rows;
	}

	@Override
	public User getUser(String userId) throws Exception {
		User ruser = sqlSession.selectOne(MAPPER_NAME+"getUser",userId);
		return ruser;
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		List<User> ruser = sqlSession.selectList(MAPPER_NAME+"getUserList",user);
		return ruser;
	}

}
