package com.jvwl.train.action.login;

import com.jvwl.train.action.base.BaseAction;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		log.info("用户名："+username+"，密码："+password);
		if("admin".equals(username)&&"admin".equals(password)){
			return SUCCESS;
		}else{
			return "fail";
		}
	}

	
}
