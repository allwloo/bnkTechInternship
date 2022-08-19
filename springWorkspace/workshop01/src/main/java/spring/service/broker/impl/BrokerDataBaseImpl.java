package spring.service.broker.impl;

import java.util.ArrayList;

import spring.service.broker.BrokerDatabase;
import spring.service.broker.vo.Customer;
import spring.service.broker.vo.Stock;

public class BrokerDataBaseImpl implements BrokerDatabase {

	
	private ArrayList<Customer> customers;
	private ArrayList<Stock> stocks;
	
	public BrokerDataBaseImpl() { // 0개인채로 생성
		customers = new ArrayList<>();
		stocks = new ArrayList<>();
	}
	
	public BrokerDataBaseImpl(Customer customer, Stock stock) { // 하나씩만 주입
		super();
		customers = new ArrayList<>();
		stocks = new ArrayList<>();
		customers.add(customer);
		stocks.add(stock);
		
	}
	
	public BrokerDataBaseImpl(ArrayList<Customer> customers, ArrayList<Stock> stocks) { // 목록 주입
		super();
		this.customers = customers;
		this.stocks = stocks;
		
	}




	@Override
	public void registerCustomer(Customer c) { // 회원 한명 등록
		customers.add(c);
		System.out.println("등록한 고객은: "+c.toString());

	}

	@Override
	public void registerStock(Stock s) { // 주식 한명 등록
		stocks.add(s);
		System.out.println("등록하 주식은: "+s.toString());
	}

	@Override
	public void getAllCustomer() { // 전부 출력
		
		for(Customer c : customers) {
			System.out.println(c.toString());
		}
		System.out.println("전체 고객 탐색 완료~");

	}

	@Override
	public void getAllStock() { // 전부 출력
		
		for(Stock s : this.stocks) {
			System.out.println(s.toString());
		}
		// TODO Auto-generated method stub
		System.out.println("전체 주식 탐색 완료~");
	}

}
