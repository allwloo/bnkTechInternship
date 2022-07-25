package com.edu.user.test;

import java.util.Scanner;

class UnderAgeBoom extends Exception{ // 생성자 오버로딩을 사용해서
	
	UnderAgeBoom(){ this("This is UnderAgeBoomException"); } //눈에 보이든 안보이든 자식 생성자 호출할때 부모 생성자 super()호출 무조건무조건무조건무조건무조건무조건무조건 호출 이거 시험에 나옴
	
	UnderAgeBoom(String message){super(message);}
	
} // 왜 이렇게 해야 하는가???

class AdultMovieService{
	public void entrance(int age) throws UnderAgeBoom {
		if(age>=19) System.out.println("Ticketing OK..... Enter!! ");
		else throw new UnderAgeBoom("나이 좀 더 먹고 오삼....ㅋ"); // 내가 터트리는 예외 앞에 throw를 붙인다.
	}
}


public class UserExceptionTest {

	public static void main(String[] args) {
		AdultMovieService service = new AdultMovieService();
		Scanner sc = new Scanner(System.in);
		
		try {
			service.entrance(sc.nextInt());
		} catch (UnderAgeBoom e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("오후 10시가 되어서 극장문을 닫습니다.");
		}
		System.out.println("Exit....");

	}

}
