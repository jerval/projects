package com.jvwl.train.action.base;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author jerval
 */
@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements RequestAware,
		SessionAware {

	protected Log log = LogFactory.getLog(this.getClass());
	protected String info;
	protected Map<String, Object> request;
	protected Map<String, Object> session;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
