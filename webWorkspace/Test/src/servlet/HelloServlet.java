package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*<servlet>
 *	    <servlet-name>HelloServlet</servlet-class>
 * 		<servlet-class>servlet.HelloServlet</servlet-class>
 * </servlet>
 * 
 * 
 * <servlet-mapping>
 * 		<servlet-name>HelloServlet</servlet-name>
 * 		<url-patters>/HelloServlet</url-pattern>
 * <servlet-mapping>
 * 
 */


@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlet....프로그램 구동중....");
		
		request.getRequestDispatcher("reslut.jsp").forward(request, response);
	}

}
