package org.carryli.work.action;
import org.carryli.work.entity.User;
import org.carryli.work.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/login", method = RequestMethod.POST, headers="Accept=*/*")
	public String check2Login(@ModelAttribute("user")User user,ModelMap model)
	{
		System.out.println("insert into 2 sbaction");
	    if (userService.checkLogin(user))
	    {
	    	return "success";
	    }
	    return "study";
	}
	
}