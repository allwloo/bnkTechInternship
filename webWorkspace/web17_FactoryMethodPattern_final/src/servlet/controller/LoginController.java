package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LoginController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		String path = "login.html";
		try {
			MemberVO rvo = MemberDAOImpl.getInstacne().login(id, pass);
			//요청하면 세션은 서버에 자동적으로 만들어지고.. 개발자는 그걸 받아서 사용....
			HttpSession session = request.getSession();
			if(rvo!=null) { // 로그인 성공시 바인딩
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: "+session.getId());
				path = "login.result.jsp";
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return new ModelAndView(path);
	}
}
