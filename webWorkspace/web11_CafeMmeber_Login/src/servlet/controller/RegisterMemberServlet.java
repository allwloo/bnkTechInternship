package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

/**
 * Servlet implementation class RegisterMemberServlet
 */
@WebServlet("/Register")
public class RegisterMemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * 1. 한글처리
		 * 2. 폼값 받는다
		 * 3. vo객체 생성
		 * 4. DAO리턴 받아서
		 * 5. 비지니스 로직 호출
		 * 6. 네비게이션.... REGISTER_RESULT.jsp
		 */
		
		MemberVO m1 = new MemberVO(request.getParameter("id"),
								request.getParameter("password"),
								request.getParameter("name"),
								request.getParameter("address"));
		MemberDAOImpl dao = MemberDAOImpl.getInstacne();
		try {
			dao.registerMember(m1);
//			request.getRequestDispatcher("register_result.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
		response.sendRedirect("AllMember");
		
	}
}
