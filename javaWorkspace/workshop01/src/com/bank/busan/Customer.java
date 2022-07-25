package com.bank.busan;

public class Customer {
	public String name;
	public Account account;
	public String address;
	
	public Customer(String name, Account account, String address) { // Customer 생성시 name, account, address 모두 생성
		super();
		this.name = name;
		this.account = account;
		this.address = address;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public String getName() {
		return name;
	}
	
}
