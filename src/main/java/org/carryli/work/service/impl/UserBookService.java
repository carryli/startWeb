package org.carryli.work.service.impl;

import java.util.List;

import org.carryli.work.entity.UserBook;


 

public interface UserBookService {
	
	public UserBook findRecordById(Integer recordId);
	
	public boolean delete(int recordId);
	
	public boolean add(UserBook userBook);
	
}
