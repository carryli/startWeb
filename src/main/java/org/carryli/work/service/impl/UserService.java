package org.carryli.work.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.carryli.work.entity.User;


 

public interface UserService {
//	public Serializable save(User user);
//	public User get(Class<User> c, Serializable id);
//	public User get(String hql, Map<String, Object> params);
//	public User load(Class<User> c, Serializable id);
//	public User getObject(String hql,  Object[] params);
//	public int executeHql(String hql);
	public boolean checkLogin(User user);
//	public List<User> queryAll(Class<User> c);
//	public User getByNo(Class<User> c, String no);
//	public User getByHql(String hql);
	public void delete(User user);
	public void update(User user);
	public void add(User user);
	public boolean exist(String username);
	public List<User> findAll();
//	public void reset(Integer id);
//	public String queryOneField(String hql);
}
