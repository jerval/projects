package com.jvwl.examination.dto;
/*
 * author:jerval
 */
public class Message {

	private String msg;  //消息
	private Boolean state;   //成功与否
	private String toURL;  //将要转去的URL

	public Message(String msg, Boolean state, String toURL) {
		this.msg = msg;
		this.state = state;
		this.toURL = toURL;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getToURL() {
		return toURL;
	}

	public void setToURL(String toURL) {
		this.toURL = toURL;
	}

	@Override
	public String toString() {
		return "Message [msg=" + msg + ", state=" + state + ", toURL=" + toURL
				+ "]";
	}

}
