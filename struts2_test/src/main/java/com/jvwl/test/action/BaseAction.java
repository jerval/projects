package com.jvwl.test.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport{

	@SuppressWarnings("unchecked")
	protected Map sessionMap ;
	
	@SuppressWarnings("unchecked")
	public BaseAction(){
		sessionMap = (Map)ActionContext.getContext().get("request");
	}
	
}
