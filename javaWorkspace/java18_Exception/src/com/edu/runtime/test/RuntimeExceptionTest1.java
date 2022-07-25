package com.edu.runtime.test;

public class RuntimeExceptionTest1 {

	public static void main(String[] args) {
		
		String[] str = {
				"Hello",
				"No , I mean it",
				"Nice to meet you",
		};
		int i = 0;
		while(i<100) {
			try {
				System.out.println(str[i]); // 예외는 "줄단위로 발생"
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice Catch");
			}
			i++;	// 자바에서 예외 ---> 객체
		}
		System.out.println("while loop end.....");
	}

}
