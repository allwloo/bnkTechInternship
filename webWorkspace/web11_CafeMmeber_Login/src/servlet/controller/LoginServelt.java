package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/LoginServelt")
public class LoginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요것도 문제 냄
		/*
		 * 1. 한글
		 * 2. 폼값받아오기
		 * 3. VO 생성
		 * 4. DAO 리턴받기 비지니스로직 호출 반환값
		 * 5. 어트리뷰트에 바인딩...로그인 하는동안 vo 정보를 저장.... HttpSession에 저장
		 * 6. 페이지 네비게이션
		 */
		
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		String path = "index.html";
		try {
			MemberVO rvo = MemberDAOImpl.getInstacne().login(id, pass);
			//요청하면 세션은 서버에 자동적으로 만들어지고.. 개발자는 그걸 받아서 사용....
			HttpSession session = request.getSession();
			if(rvo!=null) { // 로그인 성공시 바인딩
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: "+session.getId());
				path = "login.result.jsp";
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
