package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankArrayTest2 {

	public static void main(String[] args) {
		Account[] accounts = { new Account(10000, "부산은행"),
								new Account(20000, "국민은행"),
								new Account(30000, "신한은행")
		};
		
		Customer james = new Customer(111, "James");
		
		//1. James가 3개의 통장을 개ㅓㄹ... 부산, 국민, 신한은행
		james.setAccounts(accounts);
		
		//2. James가 개설한 통장중에서 ㅜㅂ산은행 통장을 받아온다.
		Account[ ] returnAcc = james.getAccounts();
		Account busanBK = null;
		for(Account acc: returnAcc) {
			if(acc.getBankName().equals("부산은행"))	busanBK = acc;
		}
		
		System.out.println("부산은행 통장에 입금하기.");
		busanBK.deposit(900.0);
		busanBK.deposit(30000.0);
		System.out.println("부산은행 통장에 출금하기");
		busanBK.withdraw(50000.0);
		busanBK.withdraw(30000.0);
		System.out.println("부산은행 잔액 확인하기");
		System.out.println("잔액확인 :"+busanBK.getBalance());
		
	}
}
