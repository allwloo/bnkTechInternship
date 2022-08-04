package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//2,3
		
		Member m1 = new Member(request.getParameter("name"),
								Integer.parseInt(request.getParameter("age")),
								request.getParameter("address"));
		
		//4,5 생략
		
		//6
		request.getRequestDispatcher("register_result.jsp").forward(request, response);
	
		
		
		/*
		 * 1. 양방향 한글처리
		 * 2. 폼값 받아온다
		 * 3. 받은 값을 바탕으로 vo 생성
		 * 4. DAO리턴받는다
		 * 5. 비즈니스 로직 호출 (반환값) ---> 중요함
		 * 6. 페이지 이동(네비게이션)
		 * 
		 */
	}

}
