package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) {// 세션에 반드시 바인딩해야하는게 2가지 -> 로그인, 회원정보수정
				session.invalidate();
				path = "logout.jsp";
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return new ModelAndView(path);
	}
}
