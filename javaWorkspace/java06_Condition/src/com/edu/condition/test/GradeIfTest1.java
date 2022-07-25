package com.edu.condition.test;
//성적을 제어하는 프로그램을 작성..
// Field 선언은 클래스 바로 아래 / 메소드 블락 바깥
//선언된 위치로 필드와 로컬변수가 구분되다.
public class GradeIfTest1 {

	public static void main(String[] args) {
		
		int grade = 88;
		if(grade<=100&&grade>=90) { //false
			System.out.println("A Grade");
		}else if(grade<90 && grade>= 80){
			System.out.println("B Grade");
		}else if(grade<80 && grade>= 70){
			System.out.println("C Grade");
		}else {
			System.out.println("Try again");
		}

	}

}
