package com.edu.oop.test;
/*
 * NoteBookTest의 문제점
 * ::
 * 필드가 많아질수록 코드라인이 늘어남
 * 더우기 생성되는 객체가 커질수록 코드량은 기하급수적으로 증가한다.
 * 
 * 필드에 값을 직접(direct)로 할당하면 발생하는 문제점
 * ::
 * 
 * 
 * ---------------------------------------------------------------------
 * NoteBookTest의 해결책
 * 필드 초기화해주는 기능을 만든다.
 * 
 */

import com.edu.oop.NoteBook;

public class NoteBookTest {

	public static void main(String[] args) {
		
		NoteBook n1 = new NoteBook();
		
		n1.setNoteBookInfo("samsung", 1000000, 10052954);
		
//		n1.brand = "Renover";
//		n1.price = 1200000;
//		n1.serialNumber = 10052954;
//		
//		n1.printNoteBookInfo();
		System.out.println("NoteBookInfo :: "+n1.getBrand()+","+n1.getPrice()+","+n1.getSerialNumber());

	}

}
