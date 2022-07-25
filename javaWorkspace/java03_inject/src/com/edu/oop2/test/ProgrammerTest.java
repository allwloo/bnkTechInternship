package com.edu.oop2.test;

import com.edu.oop2.NoteBook;
import com.edu.oop2.Programmer;

public class ProgrammerTest {

	public static void main(String[] args) {
		
		Programmer man1 = new Programmer();
		NoteBook nb1 = new NoteBook();
		man1.setProgrammerInfo("영미정", "Java", 50000000, "부산광역시 연제구 815-59번지 경도빌라 401호");
		nb1.setNoteBookInfo("Samsung", 1000000, 10052954);
		
		man1.buyNoteBook(nb1);
		
		NoteBook man1nb1 = new NoteBook();
		man1nb1 = man1.getNoteBook();
		// -> man1nb1를  man1.getNoteBook()과 대체가능
		
		System.out.println(man1.getNoteBook().getNoteBookInfo());
		System.out.println(man1.getNoteBook().getBrand());
	}

}
