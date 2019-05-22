package org.carryli.work.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 访问:localhost:8080/start_j2ee/hello.do
 * 根据dispatcher-servlet.xml的配置hello.do,交给对应的Controller
 * 执行这里的代码,ModelAndView转到/spirngmvc/helloworld.jsp
 * 
 * 更改web.xml中SpringMVC拦截的URL后缀为html
 * http://localhost:8080/start_j2ee/hello.html
 * @author Administrator
 *
 */
@Controller
public class HelloController {
	@RequestMapping("login.html")
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("login"); //视图名称:helloword,结合ViewResolver,找到对应的视图路径
		mav.addObject("message", "Hello World!"); //添加模型数据
		return mav;
	}
	
	@RequestMapping(value = "/error_404", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public ModelAndView error_404(@ModelAttribute("exception")Exception ex, ModelAndView mav) throws Exception {
		mav.addObject("{\"msg\":\"找不到页面\",\"code\":\"1000001\"}");
		mav.setViewName("errorMsg");
		return mav;
	}
	/**
	 * 服务器异常
	 * @return
	 * String
	 */
	@RequestMapping(value ="/error_500", produces = "text/html;charset=UTF-8")
	public ModelAndView error_500(@ModelAttribute("exception")Exception ex, ModelAndView mav) throws Exception {
		mav.addObject("{\"msg\":\"服务器处理失败\",\"code\":\"1000002\"}");
		mav.setViewName("error");
		return mav;
	}
}