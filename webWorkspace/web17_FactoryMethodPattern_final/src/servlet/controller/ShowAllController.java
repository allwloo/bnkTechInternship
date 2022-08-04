package servlet.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class ShowAllController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		try {
			ArrayList<MemberVO> list = MemberDAOImpl.getInstacne().showAllMember();
			request.setAttribute("list", list);
			path = "allView.jsp";
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return new ModelAndView(path);
	}
}
