package com.jvwl.action;

import com.jvwl.dao.PageDao;
import com.jvwl.dispatch.Dispatcher;
import com.jvwl.util.HtmlUtil;
import com.jvwl.util.TimeUtil;
import com.jvwl.model.Message;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class MsgAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private PageDao pageDao;
    private String msg;

    public PageDao getPageDao() {
        return pageDao;
    }

    public String getMsg() {
        return msg;
    }

    @Action(value = "index", results = {
        @Result(location = "/message.jsp")})
    public String showMsg() {
        int pageNum;
        String num = (String) ServletActionContext.getRequest().getParameter("pageNum");
        if (num == null || num.equals("")) {
            pageNum = 1;
        } else {
            pageNum = Integer.parseInt(num);
        }
        pageDao = Dispatcher.showMsgs(30, pageNum);
        return SUCCESS;
    }

    @Action(value = "addmsg", results = {
            @Result(type = "redirectAction", location = "index"),
            @Result(name = "result", location = "/result.jsp")})
        public String addMsg() {
            Message m = new Message();
            m.setIp(ServletActionContext.getRequest().getLocalAddr());
            m.setRegtime(TimeUtil.getTime());
            m.setContent(HtmlUtil.filterHtml(ServletActionContext.getRequest().getParameter("message")));
            if (Dispatcher.addMsg(m)) {
                return SUCCESS;
            } else {
                msg = "ÃÌº”¡Ù—‘ ß∞‹£¨«Î÷ÿ–¬ÃÌº”£°";
                return "result";
            }
        }
}
