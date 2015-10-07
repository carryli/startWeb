package org.carryli.work.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.carryli.work.dao.UserDao;
import org.carryli.work.entity.User;
import org.carryli.work.service.impl.UserService;

 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;


	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public boolean checkLogin(User user) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("username",user.getUsername()));
		criterions.add(Restrictions.eq("password",user.getPassword()));
		List<User> users = userDao.query(criterions.toArray(new Criterion[criterions.size()]));
		return users.size()>0;
	}

	@Override
	public void add(User user) {
		userDao.save(user);
	}

	@Override
	public boolean exist(String username) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("username",username));
		List<User> users = userDao.query(criterions.toArray(new Criterion[criterions.size()]));
		return users.size()>0;
	}

	@Override
	public List<User> findAll() {
		return userDao.query();
	}

}
