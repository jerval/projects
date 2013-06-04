package com.jvwl.examination.action.user;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.model.User;
import com.jvwl.examination.service.IUserService;

@Component("userEditAction")
@SuppressWarnings("serial")
public class UserEditAction extends BaseAction {

	private IUserService<User> userService;
	private String[] ids;
	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	@Resource
	public void setUserService(
			IUserService<User> userService) {
		this.userService = userService;
	}

	@JSON(serialize = false)
	@Override
	public String execute() throws Exception {
		return "login";
	}

	@JSON(serialize = false)
	public String delete() throws Exception {
		Boolean state = true;
		for (String id : ids) {
			try {
				userService.delete(userService.find(
						User.class, Integer.parseInt(id)));
			} catch (Exception e) {
				state = false;
				e.printStackTrace();
			}
		}
		if (state) {
			message = new Message("删除数据成功！", true, null);
		} else {
			message = new Message("删除数据失败！！！\n部分数据删除时发生异常", false, null);
		}
		return SUCCESS;
	}
}
