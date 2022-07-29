package com.edu.book.dao.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.book.exception.*;
import com.edu.book.dao.BookDAO;
import com.edu.book.exception.BookNotFoundException;
import com.edu.book.exception.DuplicateISBNException;
import com.edu.book.exception.InvalidInputException;
import com.edu.book.vo.Book;

import config.ServerInfo;

public class BookDAOImpl implements BookDAO{
	
	private static BookDAOImpl dao = new BookDAOImpl();
	private BookDAOImpl() {}
	public static BookDAOImpl getInstance() {
		return dao;
	}
	

	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASS);
		System.out.println("서버 연결 완료.....");
		return conn;
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		ps.close();
		conn.close();
		
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		rs.close();
		closeAll(conn,ps);
	}

	//강사님 isbn으로 찾는데 그럼 1개밖에 나오지 않는 것 같아 수정했습니다... int -> boolean 리턴값으로....
	@Override
	public boolean isExists(String isbn, Connection conn) throws SQLException {
		String query = "SELECT isbn FROM book WHERE isbn=?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, isbn);
		ResultSet rs = ps.executeQuery();
		
		return rs.next();
	}

	@Override
	public void registerBook(Book vo) throws SQLException, DuplicateISBNException {
		
		String query = "INSERT INTO book (isbn,title,author,publisher,price) VALUES(?,?,?,?,?)";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		
		try {
			if(!isExists(vo.getIsbn(), conn)) {
				ps.setString(1, vo.getIsbn());
				ps.setString(2, vo.getTitle());
				ps.setString(3, vo.getWriter());
				ps.setString(4, vo.getPublisher());
				ps.setInt(5, vo.getPrice());
				System.out.println(ps.executeUpdate()+"권 등록 완료했습니다.");
			}else {
				 throw new DuplicateISBNException("이미 등록한 책입니다....");
			}
		}finally {
			closeAll(conn,ps);
		}
		
	}

	@Override
	public void deleteBook(String isbn) throws SQLException, BookNotFoundException {

		String query = "DELETE FROM book WHERE isbn = ?";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		
		try {
			if(isExists(isbn, conn)) {
				ps.setString(1,  isbn);
				System.out.println(ps.executeUpdate()+"권 삭제처리 하였습니다...");
			}
			else {
				throw new BookNotFoundException("삭제할 책이 없습니다.....");
			}
		}finally {
			closeAll(conn,ps);
		}
		
		
	}

	@Override
	public Book findByIsbn(String isbn) throws SQLException{
		
		String query = "SELECT isbn, title, author, publisher, price FROM book WHERE isbn=?";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = null;
		Book b = new Book();
		
		try {
			if(isExists(isbn, conn)){
				ps.setString(1, isbn);
				rs = ps.executeQuery();
				while(rs.next()) {
					b.setIsbn(rs.getString(1));
					b.setTitle(rs.getString(2));
					b.setWriter(rs.getString(3));
					b.setPublisher(rs.getString(4));
					b.setPrice(rs.getInt(5));
				}
			}else {
				System.out.println("찾는 책이 존재하지 않습니다.....");
			}
		}finally {
			closeAll(conn,ps,rs);
		}
		
		return b;
	}

	@Override
	public Book findByTitle(String title) throws SQLException{
		
		String query = "SELECT isbn, title, author, publisher, price FROM book WHERE title LIKE ?";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = null;
		Book b = new Book();
		
		try {
			ps.setString(1, title);
			rs = ps.executeQuery();
			while(rs.next()) {
				b.setIsbn(rs.getString(1));
				b.setTitle(rs.getString(2));
				b.setWriter(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setPrice(rs.getInt(5));
			}
		}finally {
			closeAll(conn,ps,rs);
		}
		
		return b;
	}

	@Override
	public ArrayList<Book> findByWriter(String writer) throws SQLException, BookNotFoundException {
		
		String query = "SELECT isbn, title, author, publisher, price FROM book WHERE author = ?";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = null;
		ArrayList<Book> bs = new ArrayList<Book>();
		
		try {
			ps.setString(1, writer);
			rs = ps.executeQuery();
			while(rs.next()) {
				bs.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
			}
		}finally {
			closeAll(conn,ps,rs);
		}
		
		return bs;
	}

	@Override
	public ArrayList<Book> findByPublisher(String publish) throws SQLException, BookNotFoundException {

		String query = "SELECT isbn, title, author, publisher, price FROM book WHERE publisher = ?";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = null;
		ArrayList<Book> bs = new ArrayList<Book>();
		
		try {
			ps.setString(1, publish);
			rs = ps.executeQuery();
			while(rs.next()) {
				bs.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
			}
		}finally {
			closeAll(conn,ps,rs);
		}
		
		return bs;
	}

	@Override
	public ArrayList<Book> findByPrice(int min, int max) throws SQLException, InvalidInputException {
		
		String query = "SELECT isbn, title, author, publisher, price FROM book WHERE price BETWEEN ? AND ? ";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = null;
		ArrayList<Book> bs = new ArrayList<Book>();
		
		try {
			if(min<=max) {
				ps.setInt(1, min);
				ps.setInt(2, max);
				rs = ps.executeQuery();
				while(rs.next()) {
					bs.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
					}
			}else {
				throw new InvalidInputException("최소 값은 최대 값보다 작거나 같아야 합니다.");
			}
		}finally {
			if(rs==null) closeAll(conn,ps);
			else closeAll(conn,ps,rs);
		}
		
		return bs;
	}

	@Override
	public void discountBook(int per, String publish) throws SQLException {
		
		String query = "UPDATE book SET price = TRUNC(price*?) WHERE publisher = ?";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		double price = (1-per/100d);
		
		try {
			ps.setDouble(1, price);
			ps.setString(2, publish);
			System.out.println(ps.executeUpdate()+"가격 수정 완료했습니다.");
		}finally {
			closeAll(conn,ps);
		}
		
	}

	@Override
	public ArrayList<Book> findAllBook() throws SQLException {
		
		String query = "SELECT isbn, title, author, publisher, price FROM book";
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = null;
		ArrayList<Book> bs = new ArrayList<Book>();
		
		try {
			rs = ps.executeQuery();
			while(rs.next()) {
				bs.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
			}
		}finally {
			closeAll(conn,ps,rs);
		}
		
		return bs;
	}

}
