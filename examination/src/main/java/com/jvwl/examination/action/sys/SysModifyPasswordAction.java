package com.jvwl.examination.action.sys;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.dto.OperateUser;
import com.jvwl.examination.model.User;
import com.jvwl.examination.service.IUserService;
import com.jvwl.examination.util.MD5;

@Component("sysModifyPasswordAction")
@SuppressWarnings("serial")
public class SysModifyPasswordAction extends BaseAction implements SessionAware {

	private IUserService<User> userService;
	private String oldPassword;
	private String password;
	private Message message;
	private Map<String, Object> sessionMap;

	public Message getMessage() {
		return message;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JSON(serialize = false)
	@Override
	public String execute() throws Exception {
		try {
			String username = ((OperateUser) sessionMap.get("operateUser"))
					.getUsername();
			User user = (User) userService.findByUsername(username);
			if (user != null) {
				String oldPass = new MD5().getMD5ofStr(oldPassword);
				if (user.getPassword().equals(oldPass)) {
					user.setPassword(new MD5().getMD5ofStr(password));
					userService.update(user);
					message = new Message("密码修改成功，请重新登录系统！", true,
							"../../login.html");
				} else {
					message = new Message("旧密码输入有误，请重新输入！", false, null);
				}
			} else {
				return "login";
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			message = new Message("系统发生异常！<br/>原因：" + e.getMessage(), false,
					null);
		}
		return SUCCESS;
	}

	@Resource
	public void setUserService(IUserService<User> userService) {
		this.userService = userService;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
