package com.jvwl.examination.exception;


/**
 *处理系统正常运行时的消息
 * 
 * @author 蹇伟
 */
@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

	public BusinessException(String msg) {
		super(msg);
	}

	public BusinessException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
