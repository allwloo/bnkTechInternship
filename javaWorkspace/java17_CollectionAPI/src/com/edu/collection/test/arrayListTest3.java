package com.edu.collection.test;

import java.util.ArrayList;
import java.util.List;
/*
 * 
 * 			List-
 * 
 * 			ArrayList
 * 
 * 			순서를 가지면서 중복은 허용
 */
public class arrayListTest3 {

	public static void main(String[] args) {
		
		// index를 가지는 것들은 내부적으로 순서를 가진다.
		List<String> list = new ArrayList<String>();
		list.add("강호동");
		list.add("이수근");
		list.add("서장훈");
		list.add("김영철");
		list.add("이수근");
		
		System.out.println(list);
		
		
		System.out.println(list.remove(2));
		
		//2. 가장 첫번째에 아이유를 추가
		list.add(0,"아이유");
		System.out.println(list);
		
		//3. list에 저장된 사람들 중에서 서장훈을찾아ㅓ 서장훈을 ㅜㄹ력하세요
		
		list.add("서장훈");
		for(String s : list) {
			if(s.equals("서장훈"))
				System.out.println(s);
		}
		

	}

}
