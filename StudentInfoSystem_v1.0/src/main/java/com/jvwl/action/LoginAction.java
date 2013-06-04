package com.jvwl.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.jvwl.model.User;
import com.jvwl.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5422583445474153040L;
	private LoginService loginService;
	private String username;
	private String password;
	private Map<String, Object> session;

	public String login() {
		User user = loginService.login(username, password);
		if (user != null) {
			session.put("user", user);
			return "loginSuccess";
		}
		addActionError("用户名或密码错误！");
		return "loginFail";
	}

	public String logout() {
		session.clear();
		return "login";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
