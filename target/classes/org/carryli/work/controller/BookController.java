package org.carryli.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.carryli.work.entity.Book;
import org.carryli.work.service.impl.BookService;;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value = "/index.html")
	public String index(ModelMap map){
		return "manage";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Book book, ModelMap map){
		if(bookService.add(book)){
			return "success";
		}else{
			return "error";
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute Book book, ModelMap map){
		if(bookService.update(book)){
			return "success";
		}else{
			return "error";
		}
	}
	
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("id") Integer bookId, ModelMap map){
		if(bookService.delete(bookId)){
			return "success";
		}else{
			return "error";
		}
	}
	
	@RequestMapping(value = "/find")
	public String find(@RequestParam String key, ModelMap map){
		
		List<Book> books = bookService.findBookByName(key);
		Integer i = Integer.getInteger(key);
		if(i != null){
			books.add(bookService.findBookById(i));
		}
		map.addAttribute("books", books);
		return "success";
	}

	
}
