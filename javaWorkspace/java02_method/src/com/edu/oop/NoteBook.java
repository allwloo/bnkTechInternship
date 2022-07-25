package com.edu.oop;
/*
 * 어제 핵심 이슈
 * 
 * object Class							|					~ Test (테스트 클래스, 실행 클래스)
 * 메인이 없다 = 컴파일 대상										main() 이 있다 ---> 실행의 대상
 * 						
 * 구성요소													1.객체생성==클래스의 멤버를 메모리에 올린다
 * 필드(멤버변수) : 값이 저장되는 공간								2.접근
 * 메소드(함수)  : 기능											   필드 -> 값 할당
 * 															    메소드 -> 호출
 
 *ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 */
public class NoteBook {
	//1. 필드 선언
	public String brand;
	public int price;
	public int serialNumber;
	
	//2. 메소드
	public void printNoteBookInfo() //메소드 선언부 .. return type + 메소드 이름 (매개변수)
	{
		System.out.println("NoteBookInfo :: "+brand+","+price+","+serialNumber); // 메소드 구현부
	}
	
	//3. 메소드 추가
	// 노트북의 브랜드를 리턴하는 기능을 추가.
	
	public String getBrand() {
		return brand; // 메소드를 호출한 지점으로 값이 리턴된다.
	}
}
