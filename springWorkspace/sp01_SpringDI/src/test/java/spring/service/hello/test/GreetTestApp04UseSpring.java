package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.dao.MemberDAO;
import spring.service.dao.impl.MemberDAOImpl;

public class GreetTestApp04UseSpring {

	/// main method
	public static void main(String[] args) {
		
		//1. BeanFactory(Spring Container(?))을 이용 xml 에 선언적으로 기술된 instance 정보 획득
		BeanFactory factory =
				new XmlBeanFactory( new FileSystemResource
				("./src/main/resources/config/dao.xml") ); // 얘가 컨테이너래...! ioc컨테이너.. bean컨테이너...

		MemberDAO dao = (MemberDAO)factory.getBean("dao");
		// dao로 리턴받아야 함... 부모 객체
		// 자바코드에서는 무조건 인터페이스만 노출
		
		dao.regsiter("1234", "5678");
		dao.delete("1234");
		
		
		
	}
	
}//end of class