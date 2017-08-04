package com.mvc.api;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@Autowired
	private User user;
	
	@InitBinder
	protected void initBinder(ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(java.sql.Date.class, dateEditor);
		binder.registerCustomEditor(java.util.Date.class, dateEditor);
	}
	
	@RequestMapping("/hello")
	public String test() {
		return "hello";
	}
	
	@RequestMapping("/vivi")
	public ModelAndView vivi() {
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("flag", true);
		return new ModelAndView("/vivi", "model", model);
	}
	
	@RequestMapping("/ajax")
	@ResponseBody
	public User ajax(String id) {
		System.out.println("id:"+id);
		user.setName("vivi");
		return user;
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
	public String form(@ModelAttribute("user") User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String value = request.getHeader("Accept-Encoding");
		//System.out.println(value);
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		if(session.isNew()) {
			System.out.println("session创建成功 id:" + sessionId);
		}else {
			System.out.println("session已存在 id:" + sessionId);
		}
		
		response.getWriter().print("hello vivi");
		
		return "form";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String form(@Validated User user, BindingResult br, HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String vivi = null;
		
		Map<String, String[]> paramMap = request.getParameterMap();
		for(Map.Entry<String, String[]> entry :paramMap.entrySet()) {
			String paramName = entry.getKey();
			System.out.println(paramName);
			String[] paramValueArr = entry.getValue();
			
			for(String paramValue: paramValueArr) {
				System.out.println(paramValue);
			}			
		}
		
		//RequestDispatcher reqDispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
		//reqDispatcher.forward(request, response);
		
		if(br.hasErrors()) {
			user.setName("wrong");
		}
		//user.setName("post");
		request.setAttribute("hello", "hellovivi");
		//System.out.println("hello " + vivi);
		request.setAttribute("vivi", "dfdfd");
		//System.out.println("hello " + request.getAttribute("vivi"));
		
		String url = request.getParameter("url");
	//	System.out.println("url: " + url);
		Cookie c = new Cookie("url", url);
		c.setMaxAge(1000);
		response.addCookie(c);
		
		return "form";
	}
	
	@RequestMapping("/in1")
	public String in1(User user, Model model) {
		//model.addAttribute(new User());
		user.setName("post");
		model.addAttribute("name", "vivi");
		//model.addAttribute("command", user);
		return "form";
	}
	
	@RequestMapping("/in2")
	public ModelAndView in2() {
		return new ModelAndView("redirect:hello");
	}
	
	@RequestMapping("/map")
	public ModelAndView map() {
		ModelAndView view = new ModelAndView("hello");
		Map map = new HashMap<String, User>();
		User user = new User();
		user.setName("mapUser");
		map.put("user", user);
		view.addObject("user", map);
		return view;
	}
}
