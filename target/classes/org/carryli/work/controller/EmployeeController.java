package org.carryli.work.controller;

import java.util.List;

import org.carryli.work.entity.Address;
import org.carryli.work.entity.Employee;
import org.carryli.work.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	public EmployeeService getEmployeeService(){
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService){
		this.employeeService =employeeService;
	}
	@RequestMapping(value="register",method=RequestMethod.POST, headers="Accept=*/*" )
	public String Register(@ModelAttribute("employee")Employee employee, ModelMap model){
		List<Employee> employees=employeeService.findAll();
		
		if(employees !=null && employees.size()!=0){
			model.put("employees", employees);
			return "success";
		}else{
			employee = new Employee();
			employee.setName("carryli1000");
			employee.setSalary(1234.23);
			Address address = new Address("SAN","0287673","address_line1");
			employee.setAddress(address);
			
			employeeService.add(employee);
			return "success";
		}
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET, headers="Accept=*/*")
	public ModelAndView listEmployee (@RequestParam("msg")String msg, ModelAndView mav){
		List<Employee> employees = employeeService.findAll();
		mav.addObject("msg", msg);
		mav.addObject("employees",employees);
		mav.setViewName("success");
		return mav;
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.GET, headers="Accept=*/*")
	public ModelAndView listEmployee (@RequestParam("employeeid")Integer empid, ModelAndView mav){
		boolean result = employeeService.delete(Employee.class, empid);
		mav.addObject("msg", "dleete "+(result?"success":"failed"));
		mav.setViewName("redirect:/employee/list.html");
		return mav;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.GET, headers="Accept=*/*")
	public ModelAndView save(ModelAndView mav){
		Employee employee = new Employee();
		employee.setName("carryli1000");
		employee.setSalary(1234.23);
		Address address = new Address("SAN","0287673","address_line1");
		employee.setAddress(address);
		
		employeeService.add(employee);
		mav.addObject("msg", "save finish");
		//this [:/] means the root directory
		mav.setViewName("redirect:/employee/list.html");
		return mav;
	}
}
	
	