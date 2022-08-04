package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.ProductDAO;
import servlet.model.ProductDAOImpl;
import servlet.model.ProductVO;

/**
 * Servlet implementation class RegisterProductServlet
 */
@WebServlet("/Register")
public class RegisterProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int key = 0;
		request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ProductVO p1 = new ProductVO(request.getParameter("name"),
								request.getParameter("price"),
								request.getParameter("detail"));
		ProductDAO dao = ProductDAOImpl.getInstacne();
		try {
			key = dao.registerProduct(p1);
			p1.setPronum(key);
			request.setAttribute("p1", p1);
		}catch(Exception e) {
			System.out.println(e);
		}
		request.getRequestDispatcher("register_result.jsp?key="+key).forward(request, response);
	}

}
