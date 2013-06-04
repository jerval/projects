package com.jvwl.examination.action.login;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.LoginInfo;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.dto.OperateEmployee;
import com.jvwl.examination.dto.OperateUser;
import com.jvwl.examination.model.Employee;
import com.jvwl.examination.model.User;
import com.jvwl.examination.service.IEmployeeService;
import com.jvwl.examination.service.IUserService;
import com.jvwl.examination.util.MD5;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Component("loginAction")
public class LoginAction extends BaseAction implements ModelDriven<LoginInfo>,
		SessionAware {

	private IUserService<User> userService;
	private IEmployeeService<Employee> employeeService;
	private Map<String, Object> sessionMap;
	private LoginInfo loginInfo = new LoginInfo();
	private Message message;

	public Message getMessage() {
		return message;
	}

	@Resource
	public void setEmployeeService(IEmployeeService<Employee> employeeService) {
		this.employeeService = employeeService;
	}

	@Resource
	public void setUserService(IUserService<User> userService) {
		this.userService = userService;
	}

	@Override
	@JSON(serialize = false)
	public LoginInfo getModel() {
		return loginInfo;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	@Override
	@JSON(serialize = false)
	public String execute() throws Exception {
		System.out.println(loginInfo.getType());
		if ("1".equals(loginInfo.getType())) {
			try {
				loginInfo.setPassword(new MD5().getMD5ofStr(loginInfo
						.getPassword()));
				User user = userService.login(loginInfo);
				if (user != null) {
					sessionMap.put("operateUser", new OperateUser(user
							.getUsername(), user.getLevel()));
					message = new Message(null, true, "manager/adminIndex");
				} else {
					message = new Message("用户名或密码错误！！！", false, null);
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
				message = new Message("系统发生错误，请重试！<br/>原因：" + e.getMessage(),
						false, null);
			}
			return SUCCESS;
		} else if ("0".equals(loginInfo.getType())) {
			try {
				loginInfo.setPassword(new MD5().getMD5ofStr(loginInfo
						.getPassword()));System.out.println(loginInfo.getUsername()+loginInfo.getPassword());
				Employee employee = employeeService.login(loginInfo);
				if (employee != null) {
					OperateEmployee operateEmployee = new OperateEmployee();
					operateEmployee.setEmp_id(employee.getEmp_id());
					operateEmployee.setEmp_name(employee.getEmp_name());
					operateEmployee.setDepartment(employee.getDepartment());
					sessionMap.put("operateEmployee", operateEmployee);
					message = new Message(null, true, "employee/employeeIndex");
				} else {
					message = new Message("ID或密码错误！！！", false, null);
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
				message = new Message("系统发生错误，请重试！<br/>原因：" + e.getMessage(),
						false, null);
			}
			return SUCCESS;
		} else {
			message = new Message("用户类型不能解析！！！", false, null);
			return SUCCESS;
		}
	}

	@JSON(serialize = false)
	public String logout() throws Exception {
		sessionMap.clear();
		return "login";
	}
}
