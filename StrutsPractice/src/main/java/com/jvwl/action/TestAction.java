package com.jvwl.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TestAction extends ActionSupport {
	private Boolean bool;

	public Boolean getBool() {
		return bool;
	}

	public void setBool(Boolean bool) {
		this.bool = bool;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(bool);
		return SUCCESS;
	}
}
