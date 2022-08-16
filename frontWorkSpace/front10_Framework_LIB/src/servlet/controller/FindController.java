package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String idString = arg0.getParameter("id");
		MemberVO vo = MemberDAOImpl.getInstance().findByIdMember(idString);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("find_ok.jsp");
		mv.addObject("message","Hello~~,"+vo.getName());
		return mv;
	}

	
}
