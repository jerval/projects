package com.jvwl.forum.action.reply;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.jvwl.forum.action.base.BaseAction;
import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.dto.ReplyDto;
import com.jvwl.forum.model.Reply;
import com.jvwl.forum.service.ReplyService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ListAction extends BaseAction implements SessionAware,
		ModelDriven<ReplyDto> {

	private ReplyService Service;
	private ReplyDto Dto = new ReplyDto();
	private Pagination<Reply> pagination;
	private Map<String, Object> sessionMap;
	private Integer pageNo;
	private Integer pageSize;

	@Resource
	public void setReplyService(ReplyService Service) {
		this.Service = Service;
	}

	public Pagination<Reply> getPagination() {
		return pagination;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	@JSON(serialize = false)
	public String execute() throws Exception {
		if (pageNo == null) {
			pageNo = 1;
		}
		if (sessionMap.get("pageSize") == null) {
			sessionMap.put("pageSize", 10);
		} else if (pageSize != null) {
			sessionMap.put("pageSize", pageSize);
		}
		pagination = Service.findReplys(Dto,
				new PageInfo(pageNo, (Integer) sessionMap.get("pageSize")));
		return SUCCESS;
	}

	@JSON(serialize = false)
	public ReplyDto getModel() {
		return Dto;
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
