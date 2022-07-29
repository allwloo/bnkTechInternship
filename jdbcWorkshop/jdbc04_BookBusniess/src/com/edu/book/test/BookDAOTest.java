package com.edu.book.test;

import java.util.ArrayList;

import com.edu.book.dao.impl.BookDAOImpl;
import com.edu.book.vo.Book;

public class BookDAOTest {

	public static void main(String[] args) throws Exception{
		BookDAOImpl dao = BookDAOImpl.getInstance();
		Book b1 = new Book("1","위대한 개츠비","F.스콧 피츠제럴드","민음사", 9000);
		Book b2 = new Book();
		Book b3 = new Book("2","밤은 부드러워","F.스콧 피츠제럴드","문학동네", 12000);
		ArrayList<Book> b4 = new ArrayList<Book>();
		Book b5 = new Book("5", "달과 6펜스", "서머싯 몸","민음사", 9000);
		Book b6 = new Book("6", "호밀밭의 파수꾼", "J.D.샐린저","민음사",8000);
		//메소드를 try{ catch안에서 하나씩 호출하면서 작업을 마무리 하시기 바랍니다.
		try {
			//b2 = dao.findByTitle("위대한 개츠비");
			//b4 = dao.findByWriter("F.스콧 피츠제럴드");
			//dao.registerBook(b3);
			//b4 = dao.findByPublisher("민음사");
			//b4 = dao.findByPrice(199999 ,90000);
			dao.discountBook(50, "민음사");
			dao.registerBook(b6);
			dao.deleteBook("6");
			System.out.println(dao.findByIsbn("1"));
			b4 = dao.findByPrice(9000, 10000);
			for(Book b : b4)
				System.out.println(b);
			
			System.out.println(dao.findByTitle("위대한 개츠비"));
			b4 = dao.findByPublisher("민음사");
			for(Book b : b4)
				System.out.println(b);
			
			b4 = dao.findByWriter("F.스콧 피츠제럴드");
			for(Book b : b4)
				System.out.println(b);
			
			b4 = dao.findAllBook();
			for(Book b : b4)
				System.out.println(b);
			
		}catch(Exception e) {
			System.out.println("에러 메세지 "+e.getMessage());
		}finally {
			System.out.println("도서 프로그램을 종료합니다....");
		}

	}
}
