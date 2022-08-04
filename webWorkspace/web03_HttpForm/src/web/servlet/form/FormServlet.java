package web.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    /*

	     * 폼값 받는다.  request
	     * 받은 값을 브라우저로 출력..응답  response
	     */
	    
	    String id=request.getParameter("id");
	    String password = request.getParameter("password");
	    String gender = request.getParameter("gender");
	    
	    String[ ] tech=request.getParameterValues("tech");
	    

		response.setContentType("text/html;charset=utf-8");
		
		request.setCharacterEncoding("utf-8");
	    PrintWriter out=response.getWriter();
	    out.println("<html><body><h2>폼값에 입력된 정보를 출력합니다..</h2>");
	    out.println("<li>당신의 아이디 "+id+"</li>");
	    out.println("<li>당신의 패스워드 "+password+"</li>");
	    out.println("<li>당신의 성별은"+gender+"</li><br><br>");
	    
	    out.println("<b>당신이 사용가능한 기술들입니다..</b><br><br>");
	    String techs = "";
	    for(String t : tech) techs += t+"  ";
	    out.println(techs);
	    
	    out.println("</body></html>");
	}


}


