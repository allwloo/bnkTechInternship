package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.hello.Greet;

public class DAOTestApp05UseSpring {

	/// main method
	public static void main(String[] args) {
		
		//1. BeanFactory(Spring Container(?))을 이용 xml 에 선언적으로 기술된 instance 정보 획득
		BeanFactory factory =
				new XmlBeanFactory( new FileSystemResource
				("./src/main/resources/config/greet.xml") ); // 얘가 컨테이너래...! ioc컨테이너.. bean컨테이너...

		//2. Container 로 부터 hello 의 name 을 갖는 instance return 받기  
		Greet greet = (Greet)factory.getBean("greet1");
		greet.sayMessage();
		
		Greet greet2 = (Greet)factory.getBean("greet2");
		greet2.sayMessage();
		
		Greet greet3 = (Greet)factory.getBean("greet3");
		greet3.setMessage("수정수정 헬로헬로 수정헬로");
		greet3.sayMessage();
		
		Greet greet4 = (Greet)factory.getBean("greet4");
		greet4.sayMessage();
		
		Greet greet5 = (Greet)factory.getBean("greet5");
		greet5.sayMessage();
		
		Greet greet6 = (Greet)factory.getBean("greet6");
		greet6.sayMessage();
		
		
	}
	
}//end of class