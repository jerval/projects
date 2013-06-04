package com.jvwl.forum.action.user;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.jvwl.forum.action.base.BaseAction;
import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.dto.UserDto;
import com.jvwl.forum.model.User;
import com.jvwl.forum.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ListAction extends BaseAction implements SessionAware,
		ModelDriven<UserDto> {

	private UserService userService;
	private UserDto userDto = new UserDto();
	private Pagination<User> pagination;
	private Map<String, Object> sessionMap;
	private Integer pageNo;
	private Integer pageSize;

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Pagination<User> getPagination() {
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
		pagination = userService.findUsers(userDto,
				new PageInfo(pageNo, (Integer) sessionMap.get("pageSize")));
		return SUCCESS;
	}

	@JSON(serialize = false)
	public UserDto getModel() {
		return userDto;
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
