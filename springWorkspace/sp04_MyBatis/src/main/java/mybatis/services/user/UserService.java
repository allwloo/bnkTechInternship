package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

public interface UserService {

	/*
	 * 데이터 가공 레이러
	 * 게시판의 페이징 생각하면 된다.
	 * 
	 * db에서 가지고온 데이터를 조작하는 레이어
	 */
	
	void addUser(User user)throws Exception;
	void updateUser(User user)throws Exception;
	
	User getUser(String userId)throws Exception;
	List<User> getUserList(User user) throws Exception; // 동적쿼리를 위한 인자값 user
}
