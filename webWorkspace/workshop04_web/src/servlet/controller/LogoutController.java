package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Book;
import servlet.model.BookDAOImpl;
import servlet.model.User;
import servlet.model.UserDAOImpl;

public class LogoutController implements Controller{

	@Override
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
