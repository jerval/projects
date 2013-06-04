package com.jvwl.examination.action.employee;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.model.Employee;
import com.jvwl.examination.service.IEmployeeService;
import com.opensymphony.xwork2.ModelDriven;

@Component("employeeEditAction")
@SuppressWarnings("serial")
public class EmployeeEditAction extends BaseAction implements
		ModelDriven<Employee> {

	private IEmployeeService<Employee> employeeService;
	private Employee employee = new Employee();
	private String[] ids;
	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	@Resource
	public void setEmployeeService(IEmployeeService<Employee> employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getEmployee() {
		return employee;
	}

	@JSON(serialize = false)
	@Override
	public String execute() throws Exception {
		return "login";
	}

	@JSON(serialize = false)
	public String update() throws Exception {
		employee = employeeService.findClass(Employee.class, employee.getId());
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String delete() throws Exception {
		Boolean state = true;
		for (String id : ids) {
			try {
				employeeService.delete(employeeService.find(Employee.class, Integer.parseInt(id)));
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

	@Override
	@JSON(serialize = false)
	public Employee getModel() {
		return employee;
	}
}
