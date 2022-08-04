package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// command로 넘어온 값에 따라서 요청을 알 수 있고 해당 요청에 메소드를 하나씩 이곳에서 연결
		
		String command = request.getParameter("command");
		String path = "index.html";
		
		if(command.equals("register")) {
			path = register(request,response);
		}else if(command.equals("find")) {
			path = find(request,response);
		}else if(command.equals("login")) {
			path = login(request,response);
		}else if(command.equals("showAll")) {
			path = showAll(request,response);
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	private String showAll(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.html";
		try {
			ArrayList<MemberVO> list = MemberDAOImpl.getInstacne().showAllMember();
			request.setAttribute("list", list);
			path = "allView.jsp";
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return path;
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
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
				request.getRequestDispatcher(path).forward(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return path;
		
	}

	private String find(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAOImpl dao = MemberDAOImpl.getInstacne();
		String path = "find_fail.jsp";
		try {
			MemberVO m1 = dao.findByIdMember(request.getParameter("id"));
			if(m1!=null)	path = "find_ok.jsp";
			request.setAttribute("m1", m1);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return path;
	}

	public String register(HttpServletRequest request, HttpServletResponse response){
		// 회원가입 요청을 서비스 하는 로직을 작성...
		MemberVO pvo = new MemberVO(request.getParameter("id"),
				request.getParameter("password"),
				request.getParameter("name"),
				request.getParameter("address"));
		String path = "index.html";
		try {
			MemberDAOImpl.getInstacne().registerMember(pvo);
			request.setAttribute("vo", pvo);
			path = "register_result.jsp";
		}catch(Exception e) {
				System.out.println(e);
		}
		
		return path;
		
	}
	
	

}
