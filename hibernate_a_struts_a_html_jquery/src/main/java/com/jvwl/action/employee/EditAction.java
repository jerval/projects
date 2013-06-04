package com.jvwl.action.employee;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.json.annotations.JSON;

import com.jvwl.action.BaseAction;
import com.jvwl.dto.Message;
import com.jvwl.exception.BusinessException;
import com.jvwl.model.Department;
import com.jvwl.model.Employee;
import com.jvwl.service.DepartmentService;
import com.jvwl.service.EmployeeService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class EditAction extends BaseAction implements
		ModelDriven<Employee> {

	private EmployeeService employeeService = new EmployeeService();
	private DepartmentService departmentService = new DepartmentService();
	private List<Department> departments;
	private Employee employee = new Employee();
	private String[] ids;
	private Message message;

	public Message getMessage() {
		return message;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public Employee getEmployee() {
		return employee;
	}

	@JSON(serialize = false)
	@Action("update")
	public String update() throws Exception {
		employee = employeeService.findClass(Employee.class, employee.getId());
		return SUCCESS;
	}

	@JSON(serialize = false)
	@Action("delete")
	public String delete() throws Exception {
		Boolean state = true;
		for (String id : ids) {
			try {
				employeeService.delete(employeeService.find(Employee.class,
						Integer.parseInt(id)));
			} catch (Exception e) {
				state = false;
				e.printStackTrace();
			}
		}
		if (state) {
			message = new Message(getText("operate_ok"),"删除数据成功！", true, null);
		} else {
			message = new Message(getText("operate_fail"),"删除数据失败！！！\n部分数据删除时发生异常", false, null);
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	@Action("findDeparts")
	public String findDeparts() throws Exception {
		try {
			departments = departmentService.findDepartments();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public Employee getModel() {
		return employee;
	}
}
