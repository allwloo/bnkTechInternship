package spring.service.broker;

import spring.service.broker.vo.Customer;
import spring.service.broker.vo.Stock;

public interface BrokerDatabase {
	
	void registerCustomer(Customer c);
	void registerStock(Stock s);
	void getAllCustomer();
	void getAllStock();

}
