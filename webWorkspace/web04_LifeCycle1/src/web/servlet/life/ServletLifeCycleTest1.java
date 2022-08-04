package web.servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLifeCycleTest1
 */
//Annotation --- > XML
//@WebServlet("/Life1")
public class ServletLifeCycleTest1 extends HttpServlet {

	private int count = 0 ;
	
       

    public ServletLifeCycleTest1() { //서블릿 생성할때..
    	System.out.println("1. 서블릿 객체가 생성....컨테이너에 의해서...");
    }


	public void init() throws ServletException { //서블릿 생성되고 나서
		System.out.println("2. init()...호출....컨테이너에 의해서...");
	}

	public void destroy() {
		System.out.println("4. destroy() 호출... 컨테이너에 의해서");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3.service()호출.... -> doGet()/doPost()재호출.... 컨테이너에 의해서....");
		
		PrintWriter out = response.getWriter();
		// 웹브라우저로 출력
		out.println("<html><body bgcolor='yellow'>");
		out.println("<h3>LifeCycle CallBack Method.....</h3>");
		out.println("<b>Count :: </b>"+ ++count);
		out.println("</body></html>");
		out.close();
	}

}
