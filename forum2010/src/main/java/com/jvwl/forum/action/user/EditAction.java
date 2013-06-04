package com.jvwl.forum.action.user;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.json.annotations.JSON;

import com.jvwl.forum.action.base.BaseAction;
import com.jvwl.forum.common.Message;
import com.jvwl.forum.model.User;
import com.jvwl.forum.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class EditAction extends BaseAction implements ModelDriven<User> {

	private UserService userService;
	private User user = new User();
	private String[] ids;
	private Message message;

	public Message getMessage() {
		return message;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	@JSON(serialize = false)
	@Action("update")
	public String update() throws Exception {
		user = userService.findClassById(user.getId());
		return SUCCESS;
	}

	@JSON(serialize = false)
	@Action("delete")
	public String delete() throws Exception {
		try {
			userService.delete(ids);
			message = new Message(getText("operate_ok"), "删除数据成功！", true, null);
		} catch (Exception e) {
			message = new Message(getText("operate_fail"),
					"删除数据失败！！！\n部分数据删除时发生异常", false, null);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public User getModel() {
		return user;
	}
}
