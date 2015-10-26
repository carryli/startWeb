package org.carryli.work.service.impl;

import java.util.List;

import org.carryli.work.entity.Employee;

public interface EmployeeService {
	public boolean checkLogin(Employee employee);
	public Employee findEmployeeById(Integer empid);
	public boolean delete(Class c, Integer empid);
	public boolean update(Employee employee);
	public boolean add(Employee employee);
	public boolean exist(String username);
	public List<Employee> findAll();
	
}
