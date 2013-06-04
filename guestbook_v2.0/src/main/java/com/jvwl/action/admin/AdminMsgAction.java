package com.jvwl.action.admin;

import com.jvwl.dao.PageDao;
import com.jvwl.dispatch.Dispatcher;
import com.jvwl.model.Message;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class AdminMsgAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private PageDao pageDao;
	private Message message;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public Message getMessage() {
		return message;
	}

	public PageDao getPageDao() {
		return pageDao;
	}

	@Action(value = "index", results = { @Result(location = "/admin/message.jsp") })
	public String admin() {
		int pageNum;
		String num = (String) ServletActionContext.getRequest().getParameter(
				"pageNum");
		if (num == null || num.equals("")) {
			pageNum = 1;
		} else {
			pageNum = Integer.parseInt(num);
		}
		pageDao = Dispatcher.adminShowMsgs(30, pageNum);
		return SUCCESS;
	}

	@Action(value = "msgdetail", results = { @Result(location = "/admin/msgdetail.jsp") })
	public String msgDetail() {
		Long id = Long.parseLong(ServletActionContext.getRequest()
				.getParameter("id"));
		message = Dispatcher.adminShowMsg(id);
		return SUCCESS;
	}

	@Action(value = "msgdelete", results = {
			@Result(type = "redirectAction", location = "index"),
			@Result(name = "result", location = "/admin/result.jsp") })
	public String msgDelete() {
		String[] deleteId = ServletActionContext.getRequest()
				.getParameterValues("id");
		for (String id : deleteId) {
			try {
				Dispatcher.adminDeleteMsg(Long.parseLong(id));
			} catch (Exception e) {
				msg = "数据删除出错！可能已被删除，请刷新页面再试！";
				return "result";
			}
		}
		return SUCCESS;
	}
}
