package com.mvc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@Autowired
	private User user;
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "hello";
	}
	
	@RequestMapping("/model")
	public ModelAndView model() {
		ModelAndView view = new ModelAndView("hello");
		view.addObject("aKey", "aValue");
		return view;
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public User user() {
		user.setName("vivi");
		return user;
	}
}
