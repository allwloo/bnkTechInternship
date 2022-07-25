package com.edu.condition.test;

import java.util.Scanner;

/*
 * 실행 시점에서 서로 다른 성적이 입력될 수 있도록 코드를 수정.
 * Scanner 객체
 */
public class GradeSwitchTest4 {

	public static void main(String[] args) {
		
		System.out.println("성적을 입력하세요>>");
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		
		
//		System.out.println("과목을 입력하세요>>");
//		String subject = sc.next();
		switch(grade) {
		case 95:
		case 90:
			System.out.println("A grade");
			break;
		case 85:
		case 80:
			System.out.println("B grade");
			break;
		case 75:
		case 70:
			System.out.println("C grade");
			break;
		default:
			System.out.println("Try again");
		}
		
		
		sc.close();
	}

}
