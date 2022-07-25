package com.edu.array.test;
/*
 * Array
 * ::
 * Same DataType을 가지는 서로다른 값들을 하나로 묶어서 처리하는 기법
 * 배열은 객체다.
 * 
 */
public class BasicArrayTest2 {

	public static void main(String[] args) {
//		int[] arr = new int[3];
//		
//		System.out.println(arr);
//		for(int i=0; i<arr.length; i++)	System.out.println(arr[i]);
//		
//		//3. 초기화
//		arr[0] = 11;
//		arr[1] = 22;
//		arr[2] = 33;
//		
//		for(int i=0; i<arr.length; i++)	System.out.println(arr[i]);
//		

		//배열의 선언 + 생성 + 초기화를 한번에
		int[ ] arr1 = {11,22,33};
		int[ ] arr2 = {100,200,300};
//		for(int i=0; i<arr1.length;i++) System.out.println(arr1[i]);
		//advancde for 문... "뭐가 어디서 돌아가는가?"
		for(int i : arr1) System.out.println(i);
		for(int i : arr2) System.out.println(i);
		
		arr1 = arr2;
		for(int i : arr2) System.out.println(i);
		
	}

}
