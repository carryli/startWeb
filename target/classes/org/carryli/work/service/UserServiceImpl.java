package org.carryli.work.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.carryli.work.dao.UserDao;
import org.carryli.work.entity.User;
import org.carryli.work.service.impl.UserService;

 
@Service
@EnableTransactionManagement
public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	private UserDao userDao;


	public UserDao getUserDao() {
		return userDao;
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional(readOnly = true)
	public User loadUserByUsername(String username)
	    throws UsernameNotFoundException, DataAccessException {

		User user = new User();
	    user.setUsername(username);
	    user = checkLogin(user);
	    if (user == null){
	    	throw new UsernameNotFoundException("user not found");
	    }
	
	    return user;
	}


	@Override
	@Transactional(readOnly=false)
	public boolean delete(int id) {
		return userDao.delete(id);
	}

	@Override
	@Transactional(readOnly=false)
	public boolean update(User user) {
		return userDao.update(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=false)
	public User checkLogin(User user) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("username",user.getUsername()));
		if(user.getPassword() != null){
			criterions.add(Restrictions.eq("password",user.getPassword()));
		}
		Criteria criteria = userDao.createCriteria(User.class, criterions.toArray(new Criterion[criterions.size()]));
		List<User> list = criteria.list();
		if(list.size() != 0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	@Transactional(readOnly=false)
	public boolean add(User user) {
		return userDao.save(user);
	}

	@Override
	@Transactional(readOnly=false)
	public List<User> findAll() {
		return userDao.getAll();
	}
	@Override
	@Transactional(readOnly=false)
	public User findUserById(Integer id) {
		return userDao.get(id);
	}

}
