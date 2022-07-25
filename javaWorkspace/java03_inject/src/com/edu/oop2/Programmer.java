package com.edu.oop2;
/*
 * NoteBook을 가지고 있는 개발자 클래스를 정의
 * 필드 설정
 * 이름, 주요기술, 급여, 주소, 노트북
 */
public class Programmer {

	public String name;
	public String mainSkill;
	public int salary;
	public String address;
	// has a relation
	public NoteBook noteBook;
	
	//메소듸 값 주입/ 값 반환
	public void setProgrammerInfo(String name, String mainSkill, int salary, String address){
		this.name = name;
		this.mainSkill = mainSkill;
		this.salary = salary;
		this.address = address;
	}
	
	public void buyNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}
	
	public String getProgrammerInfo() {
		return name+","+mainSkill+","+salary+","+address;
	}
	
	public NoteBook getNoteBook() {
		return noteBook;
	}
	
	//기능을 추가
	
	//1. 개발자의 연봉을 리턴하는 기능
	public int getAnnualSalary() {
		return salary*12;
	}
	
	//2. 개발자의 금액을 기존보다 50만원 더 추가된 급여로 변경
	public void plusSalary() {
		salary = salary + 500000;
	}
}
