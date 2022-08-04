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
 * Servlet implementation class findMemberServlet
 */
@WebServlet("/Find")
public class FindMemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAOImpl dao = MemberDAOImpl.getInstacne();
		String path = "find_fail.jsp";
		try {
			MemberVO m1 = dao.findByIdMember(request.getParameter("id"));
			if(m1!=null)	path = "find_ok.jsp";
			request.setAttribute("m1", m1);
			//request.getRequestDispatcher("find_result.jsp?id="+m1.getId()+"&pass="+m1.getPassword()+"&addr="+m1.getAddress()+"&name="+m1.getName()).forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
