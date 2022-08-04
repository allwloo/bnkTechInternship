package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.User;
import servlet.model.UserDAOImpl;


@WebServlet("/Main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userName");
		String pass = request.getParameter("password");
		String path = "error.jsp";
		try {
			User rvo = UserDAOImpl.getInstacne().login(id, pass);
			//요청하면 세션은 서버에 자동적으로 만들어지고.. 개발자는 그걸 받아서 사용....
			HttpSession session = request.getSession();
			if(rvo!=null) { // 로그인 성공시 바인딩
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: "+session.getId());
				path = "loginSuccess.jsp";
			}
		}catch(SQLException e) {
			System.out.println(e);
			response.sendRedirect(path);
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
