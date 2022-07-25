package com.edu.oop.test;

import com.edu.oop.NoteBook;

public class NoteBookTest {

	public static void main(String[] args) {
		/*
		 * kk
		 * �� �Ҵ� / �޼ҵ� ȣ��
		 */
		
		NoteBook n1 = new NoteBook();
		
		n1.brand = "Renover";
		n1.price = 1200000;
		n1.serialNumber = 10052954;
		
		n1.printNoteBookInfo();
		System.out.println("Brand : " + n1.getBrand());

	}

}
