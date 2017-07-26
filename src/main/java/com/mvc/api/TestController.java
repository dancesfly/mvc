package com.mvc.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.bind.v2.runtime.BinderImpl;

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
	
	@RequestMapping("/modelList")
	public ModelAndView modelList() {
		ModelAndView view = new ModelAndView("helloList");
		List list = new ArrayList();
		list.add("abc");
		view.addObject("dd", list);
		view.addObject("test", "abc");
		return view;
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public User user() {
		user.setName("vivi");
		return user;
	}
	
	@RequestMapping("/para")
	@ResponseBody
	//public User para(@RequestParam("username") String name, String password) {
	public User para(User puser) {
		user.setName("right");
		return user;
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(@ModelAttribute("user") User user) {
		System.out.println("get");
		return "form";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String form(@Validated User user, BindingResult br) {
		if(br.hasErrors()) {
			user.setName("wrong");
		}
		System.out.println("post");
		user.setName("post");
		return "form";
	}
	
	@RequestMapping("/in1")
	public String in1(User user, Model model) {
		//model.addAttribute(new User());
		user.setName("post");
		model.addAttribute("name", "vivi");
		return "form";
	}
}
