package org.carryli.work.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.carryli.work.dao.BookDao;
import org.carryli.work.entity.Book;
import org.carryli.work.service.impl.BookService;

 
@Service
@EnableTransactionManagement
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;


	public BookDao getBookDao() {
		return bookDao;
	}
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Override
	@Transactional(readOnly=false)
	public boolean delete(int bookId) {
		return bookDao.delete(bookId);
	}
	
	@Override
	@Transactional(readOnly=false)
	public Book findBookById(Integer bookId) {
		return bookDao.get(bookId);
	}
	
	@Override
	@Transactional(readOnly=false)
	public List<Book> findBookByName(String name) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.ilike("bookName",name));
		return bookDao.createCriteria(Book.class, criterions.toArray(new Criterion[criterions.size()])).list();
	}
	
	@Override
	@Transactional(readOnly=false)
	public boolean update(Book book) {
		return bookDao.update(book);
	}
	
	@Override
	@Transactional(readOnly=false)
	public boolean add(Book book) {
		return bookDao.save(book);
	}
	
	@Override
	@Transactional(readOnly=false)
	public List<Book> findAll() {
		return bookDao.getAll();
	}

}
