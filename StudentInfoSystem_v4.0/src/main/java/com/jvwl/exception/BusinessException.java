package com.jvwl.exception;

public class BusinessException {
	private static final long serialVersionUID = -7852715647562898602L;

	@SuppressWarnings("unchecked")
	public static RuntimeException notExistException(Class clazz, Object id) {
		throw new RuntimeException("系统中不存在编号为： " + id + " 的"+clazz.getSimpleName());
	}
	
	@SuppressWarnings("unchecked")
	public static RuntimeException existException(Class clazz, Object id) {
		throw new RuntimeException("系统中已经存在编号为： " + id + " 的"+clazz.getSimpleName());
	}

	public static RuntimeException systemException(String info) {
		throw new RuntimeException("系统发生错误： " + info);
	}
}
