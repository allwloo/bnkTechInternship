package spring.service.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spring.service.domain.MemberVO;
import spring.service.user.impl.MemberDAOImpl;

public class MyBatisMemberTestApp {
	///Main method
	public static void main(String[] args) throws Exception{

		//==> TestUtil 의 getSqlSessionFactory()을 이용 SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		MemberDAOImpl dao = new MemberDAOImpl();
		dao.setSqlSession(session);
		
		//==> Test 용 User instance 생성  
		
		//1. MyBatisUserDAOImpl10.addUser Test  
		//dao.registerMember(new MemberVO("455","pass","최정빈","기장"));
		
		
		System.out.println(":: 2. getUser(SELECT)  ? \n " + dao.getMember("222").getName() );

		//3. MyBatisUserDAOImpl10.uadateUser Test  
		
//		MemberVO pvo = new MemberVO("222","pass","김근영","연제구");
//		dao.updateMember(pvo);
//		System.out.println(":: 3. update(UPDATE)  ? ");
//		
//		dao.deleteMember("222");
//		System.out.println(":: 4. delete");
		
		TestUtil.printList(dao.showAllMember());
		System.out.println("::5. show all");

		
		System.out.println(dao.idExist("111"));
		
		System.out.println(dao.login("111", "김근영"));
	}//end of main
}//end of class