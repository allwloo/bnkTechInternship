package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

@WebServlet("/book/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = "error.jsp";
		
		Book pvo = new Book(request.getParameter("bookNo")+"-"+request.getParameter("bookNo2")+"-"+request.getParameter("bookNo3"),
								request.getParameter("bookTitle"),
								request.getParameter("bookCategory"),
								request.getParameter("bookCountry"),
								request.getParameter("bookDate"),
								request.getParameter("bookPublisher"),
								request.getParameter("bookAuthor"),
								Integer.parseInt(request.getParameter("bookPrice")),
								request.getParameter("bookCurrency"),
								request.getParameter("bookSummary"));
		try {
			BookDAOImpl.getInstacne().registerBook(pvo);
			request.setAttribute("vo", pvo);
			path = "bookSuccess.jsp";
		}catch(Exception e) {
			System.out.println(e);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
