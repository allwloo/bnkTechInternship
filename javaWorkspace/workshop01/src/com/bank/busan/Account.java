package com.bank.busan;

public class Account {
	//변수 선언
	public int accNumber;
	public String CustName;
	public double balance; // 잔고
	public String bankName;
	
	public Account(int accNumber,String CustName, String bankName) { //계좌 생성시 은행 이름, 계좌 번호 생성
		super();
		this.accNumber = accNumber;
		this.CustName = CustName;
		this.bankName = bankName;
	}
	
	public void setBalance(double balance) { // 잔고 세터
		this.balance = balance;
	}
	

	public double getBalance() {
		return balance;
	}

	public String getAccountInfo() {
		return CustName+"의 AccountInfo:  잔고:"+balance+", 은행"+
											bankName+", 계좌번호"+
											accNumber;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void deposit(double amt) { //입금
		if(amt>=1000) balance += amt;
	}
	public void withdraw(double amt) { //출금
		if(amt<=balance) balance -= amt;
	}
}
