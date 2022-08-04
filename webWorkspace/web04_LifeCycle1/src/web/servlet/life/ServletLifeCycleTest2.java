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

public class ServletLifeCycleTest2 extends HttpServlet {

	private int count = 0 ;
	
       

    public ServletLifeCycleTest2() { //서블릿 생성할때..
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
		// 클라이언트의 서비스를 수행... 수행결과 데이터를 jsp페이지로 연결....
		count = 1004;
		//out.println("<a href=Life2.jsp?cnt="+count+">Life2.jsp로 이동</a>");
		//브라우저에서 접근하지 않고 서버에서 바로 life2로 가는코드
		request.getRequestDispatcher("life2.jsp?cnt="+count).forward(request, response);
		out.close();
	}

}
