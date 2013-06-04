package com.jvwl.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	// 参数中的Object 为下一个对象(拦截器或控制器)
	//afterCompletion方法通常用来释放资源
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {

	}

	//控制器执行完成,生成视图之前所做的动作,向模型中加入公共成员
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {

	}

	// 执行请求方法这前做的事
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {//
		// 如果返回为True则请求继续进行,否则请求中止
		return false;
	}

}
