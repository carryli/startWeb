package org.carryli.work.service;

import java.util.ArrayList;
import java.util.List;

import org.carryli.work.dao.AddressDao;
import org.carryli.work.dao.EmployeeDao;
import org.carryli.work.entity.Employee;
import org.carryli.work.service.impl.EmployeeService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service
@EnableTransactionManagement
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;
	private AddressDao addressDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public AddressDao getAddressDao() {
		return addressDao;
	}

	@Autowired
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Transactional(readOnly=false)
	public boolean delete(Class c, Integer empid){
		return employeeDao.delete(c,empid);
	}
	
	@Transactional(readOnly=false)
	public boolean update(Employee employee){
		return employeeDao.update(employee);
	}
	
	@Transactional(readOnly=false)
	public boolean checkLogin(Employee employee){
		return false;
	}
	@Override
	@Transactional(readOnly=false)
	public boolean add(Employee employee){
		return employeeDao.save(employee);
	}
	@Override
	public boolean exist (String username){
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("username", username));
		List<Employee> employees=employeeDao.query(criterions.toArray(new Criterion[criterions.size()]));
		return employees.size()>0;
	}
	@Override
	@Transactional(readOnly=false)
	public List<Employee> findAll(){
		return employeeDao.query();
	}
	@Override
	@Transactional(readOnly=false)
	public Employee findEmployeeById(Integer empid){
		return employeeDao.get(empid);
	}
}
