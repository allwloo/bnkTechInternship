package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BranchesController implements Controller {

		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("SubjectController....");
			
			//디비 갔다왔다 치고....데이타 리턴...
			
			String result = "JAVA  |  JDBC  | Back-End  | Front-End  | Framework | AI222222222222222222222";
			
			request.setAttribute("result", result); 
			return new ModelAndView("Result2.jsp");
		}
}
