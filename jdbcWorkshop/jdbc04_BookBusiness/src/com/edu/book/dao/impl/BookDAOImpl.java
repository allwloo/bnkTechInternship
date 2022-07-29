package com.edu.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.book.dao.BookDAO;
import com.edu.book.exception.BookNotFoundException;
import com.edu.book.exception.DuplicateISBNException;
import com.edu.book.exception.InvalidInputException;
import com.edu.book.vo.Book;

public class BookDAOImpl implements BookDAO{
	
	private static BookDAOImpl dao = new BookDAOImpl();
	private BookDAOImpl() {}
	public static BookDAOImpl getInstance() {
		return dao;
	}
	

	@Override
	public Connection getConnect() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int isExists(String isbn, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void registerBook(Book vo) throws SQLException, DuplicateISBNException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(String isbn) throws SQLException, BookNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book findByIsbn(String isbn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findByTitle(String isbn) throws SQLException, BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Book> findByWriter(String writer) throws SQLException, BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Book> findByPublisher(String publish) throws SQLException, BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Book> findByPrice(int min, int max) throws SQLException, InvalidInputException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void discountBook(int per, String publish) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Book> findAllBook() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
