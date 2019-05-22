package org.carryli.work.controller;

import org.carryli.work.entity.UserBook;
import org.carryli.work.service.impl.UserBookService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/userbook")
public class UserBookController {

	@Autowired
	private UserBookService userBookService;

	public UserBookService getUserBookService() {
		return userBookService;
	}

	public void setUserBookService(UserBookService userBookService) {
		this.userBookService = userBookService;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("userBook") UserBook userBook, ModelMap map){
		if(userBookService.add(userBook)){
			return "success";
		}else{
			return "error";
		}
	}
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("id") Integer recordId, ModelMap map){
		if(userBookService.delete(recordId)){
			return "success";
		}else{
			return "error";
		}
	}
	
	@RequestMapping(value = "/find")
	public String find(@RequestParam("recordId") Integer recordId, ModelMap map){
		UserBook userBook = userBookService.findRecordById(recordId);
		Hibernate.initialize(userBook);
		map.addAttribute("userBook", userBook);
		return "manage";
	}
}
