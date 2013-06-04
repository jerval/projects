package com.jvwl.examination.action.front;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.dto.OperateEmployee;
import com.jvwl.examination.model.Employee;
import com.jvwl.examination.service.IEmployeeService;
import com.jvwl.examination.util.MD5;

@SuppressWarnings("serial")
@Component("modifyPasswordAction")
public class ModifyPasswordAction extends BaseAction implements SessionAware {

	private IEmployeeService<Employee> employeeService;
	private String oldPassword;
	private String password;
	private Message message;
	private Map<String, Object> sessionMap;

	public Message getMessage() {
		return message;
	}

	public void setEmployeeService(IEmployeeService<Employee> employeeService) {
		this.employeeService = employeeService;
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
			OperateEmployee operateEmployee = ((OperateEmployee) sessionMap
					.get("operateEmployee"));
			if (operateEmployee != null) {
				Employee employee = (Employee) employeeService
						.findByEmployeeId(operateEmployee.getEmp_id());
				if (employee != null) {
					MD5 md5 = new MD5();
					String oldPass = md5.getMD5ofStr(oldPassword);
					if (employee.getPassword().equals(oldPass)) {
						employee.setPassword(md5.getMD5ofStr(password));
						employeeService.update(employee);
						message = new Message("密码修改成功，请重新登录系统！", true,
								"../../login.html");
					} else {
						message = new Message("旧密码输入有误，请重新输入！", false, null);
					}
				} else {
					message = new Message("登录信息不存在，请重新登录系统！", false,
							null);
				}
			} else {
				message = new Message("登录信息不存在，请重新登录系统！", false,
						null);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			message = new Message("系统发生异常！<br/>原因：" + e.getMessage(), false,
					null);
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
