package mybatis.services.user.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;
import mybatis.services.user.UserService;

/*
 * Presentation                        Business Logic Layer
 * 
 *| 							Service						Persistance
 * Controller						  |							|
 * |							UserService					UserDAO
 * ~Controller						  |							|
 * 							MyBatisUserServiceImp13		MyBatisUserDAOImpl13
 * 
 * 컴포넌트들... bean이라고 얘기할 수도 있다.
 * @Component : 인터페이스를 상속받은 빈이라고 생각...
 * 각각 컴포넌트
 * 컨트롤러 / 서비스 / 레파지토리
 * 
 */

/*
 * FileName : MyBatisTestApp13.java
  * ㅇ SqlMapConfig01.xml / mybatis-userservice-mapping10.xml
  * ㅇ userService13.xml 
  * ㅇ Annotation 기반 설정 Test
  */
public class MyBatisTestApp13 {
	///Main method
	public static void main(String[] args) throws Exception{

		ApplicationContext context =
			new ClassPathXmlApplicationContext(
							new String[] {	"/bean/userservice13.xml"	 }
								                                                    );
	//==> IoC Container 로 부터 획득한 UserDAO 인스턴스 획득
	UserService userService = (UserService)context.getBean("myBatisUserServiceImpl13");
	
	User user = new User("user04","주몽","user04",40,40);

	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//1.UserService.addUser(user) Test
	System.out.println(":: 1. add(INSERT)  ? ");
	userService.addUser(user);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//2.UserService.getUser(userId) Test
	user = userService.getUser("user04");
	System.out.println(":: 2. get(SELECT)  ? "+user);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//3.UserService.uadateUser(user) Test
	user.setUserName("장보고");
	System.out.println(":: 3. update(UPDATE)  ? ");
	userService.updateUser(user);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//4.UserService.getUser(userId) Test
	user = userService.getUser("user04");
	System.out.println(":: 4. get(SELECT)  ? "+user);

	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//5.UserDAO.removeUser(userId) Test
	//==> UserService 에는 removeUser가 없으므로, DAO에서 직접 호출 Test
	UserDAO userDAO = (UserDAO)context.getBean("myBatisUserDAOImpl13");
	System.out.println(":: 5. remove(DELETE)  ? "+userDAO.removeUser("user04"));
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//6.UserService.getUserList() Test
	System.out.println(":: 6. all User(SELECT)  ? ");
	List<User> list = userService.getUserList(new User());
	for (int i =0 ;  i < list.size() ; i++) {
		System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
		System.out.println( list.get(i).toString() );
	}
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		
	}//end of main
}//end of class