package org.carryli.work.dao;


import org.carryli.common.hibernate.HibernateDao;
import org.carryli.work.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao extends HibernateDao<User>{
	
}
