package com.jvwl.action.admin;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class AdminLogoutAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Action(value ="logout", results = {@Result(params = {"actionName", "index", "namespace", "/"}, type = "redirectAction")})
    public String logout() {
        ServletActionContext.getRequest().getSession().invalidate();
        return SUCCESS;
    }
}
