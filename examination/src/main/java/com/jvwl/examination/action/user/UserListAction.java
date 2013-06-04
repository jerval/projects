package com.jvwl.examination.action.user;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.UserDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.User;
import com.jvwl.examination.service.IUserService;
import com.opensymphony.xwork2.ModelDriven;

@Component("userListAction")
@SuppressWarnings("serial")
public class UserListAction extends BaseAction implements SessionAware,
		ModelDriven<UserDTO> {

	private IUserService<User> userService;
	private UserDTO userDTO = new UserDTO();
	private Pagination<User> pagination;
	private Map<String, Object> sessionMap;
	private Integer pageNo;
	private Integer pageSize;

	public Pagination<User> getPagination() {
		return pagination;
	}

	@Resource
	public void setUserService(
			IUserService<User> userService) {
		this.userService = userService;
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
		pagination = userService.findUsers(userDTO,
				new PageInfo(pageNo, (Integer) sessionMap.get("pageSize")));
		return SUCCESS;
	}

	@Override
	@JSON(serialize = false)
	public UserDTO getModel() {
		return userDTO;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
