package org.carryli.work.controller;
import java.util.List;


import org.carryli.work.entity.User;
import org.carryli.work.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController
{
	@Autowired
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/*@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute("User")User User,ModelAndView model)
	{
		System.out.println("insert into 2 sbaction");
	    if (UserService.checkLogin(User) != null)
	    {
	    	model.addObject("Username",User.getUsername());
	    	model.setViewName("success");
	    	return model;
	    }
		List<User> Users = UserService.findAll();
		model.addObject("Users", Users);
		model.setViewName("success");
	    return model;
	}*/
	
	@RequestMapping(value = "/remove.html", method = RequestMethod.GET, headers="Accept=*/*")
	public String removeById(@RequestParam("userid")int id,RedirectAttributes attr)
	{
		attr.addFlashAttribute("message","remove!!!");
	    attr.addAttribute("mess","remove ");
	    return "redirect:/userlist.html";
	}
	
	@RequestMapping(value = "/sava.html", method = RequestMethod.POST, headers="Accept=*/*")
	public ModelAndView save(@ModelAttribute("user")User user,ModelAndView model)
	{
		boolean result = userService.add(user);
	    model.addObject("message","add "+(result?"successed":"failed")+"!!!");
	    model.setViewName("redirect:/userlist.html");
	    return model;
	}
	
	@RequestMapping(value = "/userlist.html", headers="Accept=*/*")
	public ModelAndView listUser(ModelAndView model)
	{
		List<User> users = userService.findAll();
		model.addObject("users", users);
		model.setViewName("success");
	    return model;
	}
	
	@RequestMapping(value = "/edit.html", method = RequestMethod.GET, headers="Accept=*/*")
	public ModelAndView listUser(@RequestParam("addr")String addr, ModelAndView model)
	{
		List<User> users = userService.findAll();
		model.addObject("users", users);
		model.setViewName(addr);
	    return model;
	}
	
	
}