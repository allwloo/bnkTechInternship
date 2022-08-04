package web.servlet.config;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GreetingServletConfig")
public class GreetingServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String greet ="";
	private String name = "";

    public GreetingServletConfig() {
        System.out.println("1. 서블릿 객체 생성");
    }

	public void init() throws ServletException {
		//getInitParameter는 지가 가지고 있어서 그냥 쓰면 됌
		System.out.println("2. ServletConfig 객체 생성...init 호출..");
		
		greet = getInitParameter("GREET");
		System.out.println(greet+"초기화 GREET 변수입니다.");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("3. doPost 호출. 요청시마다 계속 호출....");
			
			name = request.getParameter("userName");
			
			RequestDispatcher rdp = request.getRequestDispatcher("result.jsp?greet="+greet);
			rdp.forward(request, response);
			
	}

}
