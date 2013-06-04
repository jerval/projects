package com.jvwl.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jvwl.dto.UserDTO;
import com.jvwl.model.User;
import com.jvwl.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<UserDTO>,
		SessionAware {
	private static final long serialVersionUID = 5422583445474153040L;
	private UserService userService;
	private UserDTO userDto;
	private Map<String, Object> session;

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

	public String getOperateUserName() {
		return ((User) session.get("user")).getUsername();
	}

	public String add() {
		return "add";
	}

	public String addSave() {
		userService.addUser(userDto, getOperateUserName());
		return "";
	}

	public String update() {
		return "update";
	}
	public String updateSave() {
		userService.updateUser(userDto, getOperateUserName());
		return "";
	}

	public String delete() {
		return "";
	}

	public String findOne() {
		return "";
	}

	public String findAll() {
		return "";
	}

	@Override
	public UserDTO getModel() {
		return userDto;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
