package com.jvwl.examination.action.front;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.OperateEmployee;
import com.jvwl.examination.model.Employee;
import com.jvwl.examination.service.IEmployeeService;

@Component("myInfoAction")
@SuppressWarnings("serial")
public class MyInfoAction extends BaseAction implements SessionAware{

	private Employee myInfo;
	private IEmployeeService<Employee> employeeService;
	private Map<String, Object> sessionMap;

	@Resource
	public void setEmployeeService(IEmployeeService<Employee> employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getMyInfo() {
		return myInfo;
	}

	public void setMyInfo(Employee myInfo) {
		this.myInfo = myInfo;
	}

	@Override
	public String execute() throws Exception {
		OperateEmployee operateEmployee = (OperateEmployee) sessionMap.get("operateEmployee");
		if(operateEmployee!=null){
			myInfo = employeeService.findByEmployeeId(operateEmployee.getEmp_id());
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
