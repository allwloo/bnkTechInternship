package servlet.web.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

public class GenericServletTest extends GenericServlet{

	//클라이언트의 요청이 웹서버를 거쳐서 컨테이너 아래로 내려오면 
	//이때 클라이언트의 요청을 받아서 처리하는 기능은 service()이다.
	//클라이언트의 요청이 컨테이너에 전해지면 내부저으로 service()가 호출된다.
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//클라이언트의 요청을 처리하는 로직이 여기서 작성....
		PrintWriter out = res.getWriter();
		//콘솔이 아닌 브라우저로 출력하는 기능... 그래서 html 태그를 안에다 넣어야한다.
		out.println("<html><body bgcolor=cyan>");
		out.println("<h2>hello GenericServelt</h2>");
		out.println("<h3>Deployment Discriptoer</h3>");
		out.println("</body></html>");
		out.close();
		
	}
	
	

}
