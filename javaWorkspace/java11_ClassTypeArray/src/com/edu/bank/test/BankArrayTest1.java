package com.edu.bank.test;

import com.edu.bank.Account;

public class BankArrayTest1 {

	public static void main(String[] args) {
		Account[] accounts = new Account[3]; // null 초기화
		
		for(Account acc : accounts) System.out.println(acc);
		
		System.out.println("=====================================");
		accounts[0] = new Account(10000, "부산은행");
		accounts[1] = new Account(20000, "국민은행");
		accounts[2] = new Account(30000, "신한은행");
		
		System.out.println("=====배열 안의 정보를 출력======");
		for(int i=0; i<accounts.length; i++)
		{
			System.out.println("돈: "+ accounts[i].getBalance()+"   은행: "+accounts[i].getBankName());
		}
	}
}
