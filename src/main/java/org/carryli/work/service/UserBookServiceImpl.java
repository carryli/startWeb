package org.carryli.work.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.carryli.work.dao.UserBookDao;
import org.carryli.work.entity.UserBook;
import org.carryli.work.service.impl.UserBookService;

 
@Service
@EnableTransactionManagement
public class UserBookServiceImpl implements UserBookService {
	@Autowired
	private UserBookDao userBookDao;


	public UserBookDao getUserBookDao() {
		return userBookDao;
	}

	public void setUserBookDao(UserBookDao userBookDao) {
		this.userBookDao = userBookDao;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean delete(int recordId) {
		return userBookDao.delete(recordId);
	}
	
	
	@Override
	@Transactional(readOnly=false)
	public UserBook findRecordById(Integer recordId) {
		// TODO Auto-generated method stub
		return  userBookDao.get(recordId);
	}

	@Override
	@Transactional(readOnly=false)
	public boolean add(UserBook userBook) {
		// TODO Auto-generated method stub
		return userBookDao.save(userBook);
	}

}
