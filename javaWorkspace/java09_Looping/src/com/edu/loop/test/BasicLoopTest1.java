package com.edu.loop.test;
/*
 * for ,	while
 * 
 * for(초기화; 조건식; 증감식){
 * 		//code block 
 * ]
 * 
 * while(조건식){
 * 	//code block
 * 	증감식
 * }
 */
public class BasicLoopTest1 {

	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) { // 10번 반복하는 횟수를 알 수 있다. 
			System.out.println("i : "+i);
		}
		
		int i = 10;
		while(i>0) {
			System.out.println("i : "+i);
			i--;
		}
	

	}

}
