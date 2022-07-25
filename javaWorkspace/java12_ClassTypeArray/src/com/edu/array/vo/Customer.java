package com.edu.array.vo;

public class Customer {
	private int ssn;
	private String name;
	private String address;
	
	//
	private Product[ ] products;
	
	
	public Customer(int ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}	
	
	public Product[] getProducts() {
		return products;
	}



	public void buyProducts(Product[] products) { // 셋 프로덕츠
		this.products = products;
	}

	public int getSsn() {
		return ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void changeAddress(String address) { // 주소 변경
		this.address = address;
	}	
	
	public String customerInfo() { // ssn 빼고 개인정보니깐
		return name+", "+address;
	}
}