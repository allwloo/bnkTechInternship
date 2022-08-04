package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class RegisterController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		MemberVO pvo = new MemberVO(request.getParameter("id"),
				request.getParameter("password"),
				request.getParameter("name"),
				request.getParameter("address"));
		String path = "index.jsp";
		try {
			MemberDAOImpl.getInstacne().registerMember(pvo);
			request.setAttribute("vo", pvo);
			path = "register_result.jsp";
		}catch(Exception e) {
				System.out.println(e);
		}
		
		return new ModelAndView(path);
	}
}
