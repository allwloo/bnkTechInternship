package web.controller;
/*
 * AddController....실체클래스..구상객체
 * 
 * Component
 * ::
 * 인터페이스 기반으로 만들어진 재사용성 강한 자바 클래스
 */

public class UpdateController implements Controller{
	
	
	public String handle() {
		/*
		 * 1. 폼값 받아서
		 * 2. vo 생성
		 * 3. biz 로직 호출
		 * 4. 바인딩
		 * 5. 네비게이션
		 */
		System.out.println("UpdateController...update...logic");
		return "update_reslut.jsp";
	}
}