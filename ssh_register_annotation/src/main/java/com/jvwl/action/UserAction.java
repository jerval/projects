package com.jvwl.action;

import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jvwl.model.User;
import com.jvwl.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private UserService us;
	private User user = new User();

	@Resource(name="userService")
	public void setUs(UserService us) {
		this.us = us;
	}


	@Action(value = "userAction", results = { @Result(name = "success", location = "/result.jsp") })
	public String addUser() {
		us.addUser(user);
		return "success";
	}

	public User getModel() {
		return user;
	}

}
