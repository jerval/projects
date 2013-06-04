package com.jvwl.examination.interceptor;

import java.util.Map;

import com.jvwl.examination.dto.OperateEmployee;
import com.jvwl.examination.dto.OperateUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class SecurityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> sessionMap = ActionContext.getContext()
				.getSession();
		System.out.println("interceptor is working");
		OperateUser operateUser = (OperateUser) sessionMap.get("operateUser");
		OperateEmployee operateEmployee = (OperateEmployee) sessionMap
				.get("operateEmployee");
		if (null != operateUser || operateEmployee != null) {
			System.out.println("interceptor invoke");
			return invocation.invoke();
		} else {
			System.out.println("interceptor login");
			return "login";
		}
	}
}
