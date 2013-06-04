package com.jvwl.interceptor;

import java.util.Map;

import com.jvwl.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class SecurityInterceptor extends AbstractInterceptor {

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		System.out.println("interceptor");
		if (user != null) {
			return invocation.invoke();
		}
		return "login";
	}

}
