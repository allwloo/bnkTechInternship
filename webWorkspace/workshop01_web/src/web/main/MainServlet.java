package web.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
       
	
	private String id ="";
	private String pass = "";
	
    public MainServlet() {
    	
    }

    public void init() throws ServletException {
		System.out.println("2. ServletConfig 객체 생성...init 호출..");
		
		id = getInitParameter("id");
		pass = getInitParameter("password");
		System.out.println(pass+id+"초기화 GREET 변수입니다.");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("userName").equals(id)&&request.getParameter("password").equals(pass))
			request.getRequestDispatcher("Login").forward(request, response);//성공
		else
			request.getRequestDispatcher("Error").forward(request, response);//실패
	}

}
