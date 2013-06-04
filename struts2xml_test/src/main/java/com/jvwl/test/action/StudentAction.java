package com.jvwl.test.action;

import java.util.Date;

public class StudentAction {

	private String s_id;
	private String s_name;
	private Date birthday;

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String sId) {
		s_id = sId;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String sName) {
		s_name = sName;
	}

	public String execute() {
		System.out.println(s_id + "   " + s_name);
		return "ok";
	}
}
