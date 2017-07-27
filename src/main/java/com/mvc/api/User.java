package com.mvc.api;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class User {

	@NotEmpty(message = "用户名不能为空")
	String name;
	
	Date date;

	public User() {
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}
}
