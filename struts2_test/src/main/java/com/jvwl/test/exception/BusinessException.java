package com.jvwl.test.exception;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {
	public static RuntimeException systemException(String info) {
		throw new RuntimeException("系统发生错误： " + info);
	}
}
