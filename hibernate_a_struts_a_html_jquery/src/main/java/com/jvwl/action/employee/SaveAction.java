package com.jvwl.action.employee;

import org.apache.struts2.json.annotations.JSON;

import com.jvwl.action.BaseAction;
import com.jvwl.dto.Message;
import com.jvwl.exception.BusinessException;
import com.jvwl.model.Department;
import com.jvwl.model.Employee;
import com.jvwl.service.DepartmentService;
import com.jvwl.service.EmployeeService;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

@SuppressWarnings("serial")
public class SaveAction extends BaseAction implements ModelDriven<Employee> {

	private EmployeeService employeeService = new EmployeeService();
	private DepartmentService departmentService = new DepartmentService();
	private Employee employee = new Employee();
	private Message message;

	public Message getMessage() {
		return message;
	}

	public String fail() {
		System.out.println(this.getFieldErrors().values());
		message = new Message(getText("operate_fail"), "添加员工信息失败，请重试！<br/>原因："
				+ this.getFieldErrors().values(), false, null);
		return SUCCESS;
	}

	@JSON(serialize = false)
	@Override
	@InputConfig(methodName = "fail")
	@Validations(regexFields = {
			@RegexFieldValidator(fieldName = "emp_id", message = "编号格式不正确", expression = "^(\\w){4,20}$"),
			@RegexFieldValidator(fieldName = "emp_name", message = "名称格式不正确", expression = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$") })
	public String execute() throws Exception {
		if (employee.getId() == null) {
			try {
				Department dep = departmentService.findClass(Department.class,
						employee.getDepartment().getId());
				if (dep == null) {
					throw new BusinessException(
							"所选部门不存在！<br/>可能已被别人删除，请刷新后再试，由此带来的不便敬请谅解！");
				}
				employee.setDepartment(dep);
				employee.setPassword(employee.getPassword());
				employeeService.add(employee);
				message = new Message(getText("operate_ok"), "添加员工信息成功！", true,
						"employee_list");
			} catch (RuntimeException e) {
				e.printStackTrace();
				message = new Message(getText("operate_fail"),
						"添加员工信息失败，请重试！<br/>原因：" + e.getMessage(), false, null);
			}
		} else {
			try {
				Department dep = departmentService.findClass(Department.class,
						employee.getDepartment().getId());
				if (dep == null) {
					throw new BusinessException(
							"所选部门不存在！<br/>可能已被别人删除，请刷新后再试，由此带来的不便敬请谅解！");
				}
				Employee emp = employeeService.findClass(Employee.class,
						employee.getId());
				emp.setEmp_id(employee.getEmp_id());
				emp.setEmp_name(employee.getEmp_name());
				emp.setGender(employee.getGender());
				emp.setDepartment(dep);
				emp.setVersion(employee.getVersion());
				emp.setLevel(employee.getLevel());
				emp.setBirthday(employee.getBirthday());
				emp.setPhone(employee.getPhone());
				emp.setEmail(employee.getEmail());
				emp.setAddress(employee.getAddress());
				emp.setContact(emp.getContact());
				emp.setMemo(employee.getMemo());
				emp.setDep_manager(employee.getDep_manager());
				String password = employee.getPassword();
				if (password != null && !"".equals(password)) {
					emp.setPassword(employee.getPassword());
				}
				employeeService.update(emp);
				message = new Message(getText("operate_ok"), "修改员工信息成功！", true,
						"employee_list");
			} catch (RuntimeException e) {
				e.printStackTrace();
				message = new Message(getText("operate_ok"),
						"修改员工信息失败，请重试！<br/>原因：" + e.getMessage(), false, null);
			}
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public Employee getModel() {
		return employee;
	}
}
