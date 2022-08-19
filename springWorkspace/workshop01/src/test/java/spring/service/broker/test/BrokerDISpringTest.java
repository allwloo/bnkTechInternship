package spring.service.broker.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.broker.BrokerDatabase;
import spring.service.broker.vo.Customer;
import spring.service.broker.vo.Stock;

public class BrokerDISpringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/brokerservice.xml");
		
		System.out.println("\n 세터주입=============================================================================");
		Customer c1 = (Customer)factory.getBean("customer1");
		System.out.println(c1);
		
		System.out.println("\n 생성자=============================================================================");
		Customer c2 = (Customer)factory.getBean("customer2");
		System.out.println(c2);
		
		System.out.println("\n 세터주입=============================================================================");
		Stock s1 = (Stock)factory.getBean("stock1");
		System.out.println(s1);
		
		System.out.println("\n 생성자=============================================================================");
		Stock s2 = (Stock)factory.getBean("stock2");
		System.out.println(s2);
		
		BrokerDatabase db1 = (BrokerDatabase)factory.getBean("db1");
		db1.registerCustomer(c1);
		db1.registerCustomer(c2);
		db1.registerStock(s1);
		db1.registerStock(s2);
		db1.getAllCustomer();
		db1.getAllStock();
	
		
	}

}
