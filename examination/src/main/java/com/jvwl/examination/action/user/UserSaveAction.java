package com.jvwl.examination.action.user;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.exception.BusinessException;
import com.jvwl.examination.model.User;
import com.jvwl.examination.service.IUserService;
import com.jvwl.examination.util.MD5;
import com.opensymphony.xwork2.ModelDriven;

@Component("userSaveAction")
@SuppressWarnings("serial")
public class UserSaveAction extends BaseAction implements ModelDriven<User> {

	private IUserService<User> userService;
	private User user = new User();
	private Message message;

	public Message getMessage() {
		return message;
	}

	@Resource
	public void setUserService(IUserService<User> userService) {
		this.userService = userService;
	}

	@JSON(serialize = false)
	@Override
	public String execute() throws Exception {
		return "login";
	}

	@JSON(serialize=false)
	public String addSave() throws Exception {
		try {
			user.setPassword(new MD5().getMD5ofStr(user.getPassword()));
			userService.save(user);
			message = new Message("添加用户成功！", true,"user_list.html");
		} catch (BusinessException e) {
			e.printStackTrace();
			message = new Message("添加用户失败，请重试！<br/>原因：" + e.getMessage(), false, null);
		}
		return SUCCESS;
	}

	@Override
	@JSON(serialize = false)
	public User getModel() {
		return user;
	}
}
