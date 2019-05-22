package org.carryli.work.service.impl;

import java.util.List;

import org.carryli.work.entity.Book;


 

public interface BookService {
	
	public Book findBookById(Integer bookId);
	
	public List<Book> findBookByName(String name);
	
	public boolean delete(int bookId);
	
	public boolean update(Book book);
	
	public boolean add(Book book);
	
	public List<Book> findAll();
}
