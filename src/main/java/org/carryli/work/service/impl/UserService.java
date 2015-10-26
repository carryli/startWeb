package org.carryli.work.service.impl;

import java.util.List;

import org.carryli.work.entity.User;


 

public interface UserService {

	public User checkLogin(User user);
	public User findUserById(Integer id);
	public boolean delete(int id);
	public boolean update(User user);
	public boolean add(User user);
	public List<User> findAll();

}
