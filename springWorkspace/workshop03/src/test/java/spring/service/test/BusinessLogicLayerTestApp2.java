package spring.service.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.user.MemberService;
import spring.service.user.impl.MemberDAOImpl;

public class BusinessLogicLayerTestApp2 {
	///Main method
	public static void main(String[] args) throws Exception{

		ApplicationContext context =
				new ClassPathXmlApplicationContext(
								new String[] {	"/bean/memberservice.xml"	 });
		
		MemberService memberService = (MemberService)context.getBean("memberServiceImpl");
		
		
		TestUtil.printList(memberService.showAllMember());
		
		System.out.println(memberService.getMember("455"));
		
	}//end of main
}//end of class