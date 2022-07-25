package com.edu.oop;
/*
 * Object Class
 * 
 * 필드 선언;
 * 
 * getxxx
 * 리턴타입 setxxx(x)로 구성되어 있다.
 */
public class NoteBook {

	public String brand;
	public int price;
	public int serialNumber;
	
//	public void printNoteBookInfo()
//	{
//		System.out.println("NoteBookInfo :: "+brand+","+price+","+serialNumber);
//	}

	
	public String getNoteBookInfo()
	{
		return "NoteBookInfo :: "+brand+","+price+","+serialNumber;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public int getPrice() {
		return price;
	}

	public int getSerialNumber() {
		return serialNumber;
	}
	//필드 초기화 하는 기능을 추가... setNoteBookInfo
	
	public void setNoteBookInfo(String brand, int price, int serialNumber) // 로컬변수
	{// 필드에 값을 할당, 값 주입, 반환갑은 필요 없지만 매개변수는 필요
		//필드 이름과 로컬 변수의 이름이 같을때
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}
	
}
