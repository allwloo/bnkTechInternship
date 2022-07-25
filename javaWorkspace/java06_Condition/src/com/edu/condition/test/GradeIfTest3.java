package com.edu.condition.test;

import java.util.Scanner;

/*
 * 실행 시점에서 서로 다른 성적이 입력될 수 있도록 코드를 수정.
 * Scanner 객체
 */
public class GradeIfTest3 {

	public static void main(String[] args) {
		
		System.out.println("성적을 입력하세요>>");
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		
		System.out.println("과목을 입력하세요>>");
		String subject = sc.next();
		
		if(grade<=100&&grade>=90)	System.out.println(subject+"  A Grade");
		else if(grade<90 && grade>= 80)	System.out.println(subject+"  B Grade");
		else if(grade<80 && grade>= 70)	System.out.println(subject+"  C Grade");
		else	System.out.println("Try again");
		

		
		sc.close();
	}

}
