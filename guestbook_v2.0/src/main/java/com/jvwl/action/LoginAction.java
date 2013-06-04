package com.jvwl.action;

import com.jvwl.model.Admin;
import com.jvwl.dispatch.Dispatcher;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class LoginAction extends ActionSupport implements ModelDriven<Admin> {

	private static final long serialVersionUID = 1L;
	private Admin admin = new Admin();
	private String msg;

	public String getMsg() {
		return msg;
	}

	@Action(value = "login", results = { @Result(location = "/login.jsp") })
	public String login() {
		return SUCCESS;
	}

	@Action(value = "deallogin", results = {
			@Result(params = { "actionName", "index", "namespace", "/admin" }, type = "redirectAction"),
			@Result(name = "result", location = "/result.jsp") })
	public String dealLogin() {
		if (Dispatcher.adminLogin(admin)) {
			ServletActionContext.getRequest().getSession().setAttribute(
					"username", admin.getUsername());
			return SUCCESS;
		} else {
			msg = "用户名或密码错误，请重新登录！";
			return "result";
		}
	}

	public Admin getModel() {
		return admin;
	}
}
