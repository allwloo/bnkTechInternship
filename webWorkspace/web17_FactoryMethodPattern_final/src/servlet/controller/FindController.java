package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAOImpl dao = MemberDAOImpl.getInstacne();
		String path = "find_fail.jsp";
		try {
			MemberVO m1 = dao.findByIdMember(request.getParameter("id"));
			if(m1!=null)	path = "find_ok.jsp";
			request.setAttribute("m1", m1);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return new ModelAndView(path);
	}
	
}
