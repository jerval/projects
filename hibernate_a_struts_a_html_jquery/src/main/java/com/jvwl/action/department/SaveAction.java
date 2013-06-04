package com.jvwl.action.department;

import org.apache.struts2.json.annotations.JSON;

import com.jvwl.action.BaseAction;
import com.jvwl.dto.Message;
import com.jvwl.exception.BusinessException;
import com.jvwl.model.Department;
import com.jvwl.service.DepartmentService;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

@SuppressWarnings("serial")
public class SaveAction extends BaseAction implements ModelDriven<Department> {

	private DepartmentService departmentService = new DepartmentService();
	private Department department = new Department();
	private Message message;

	public Message getMessage() {
		return message;
	}
	
	public String fail() {
		System.out.println(this.getFieldErrors().values());
		message = new Message(getText("operate_fail"),"添加部门信息失败，请重试！<br/>原因："+this.getFieldErrors().values(),
				false, null);
		return SUCCESS;
	}

	@JSON(serialize = false)
	@Override
	@InputConfig(methodName="fail")
	@Validations(regexFields ={ @RegexFieldValidator(fieldName = "depart_id", message = "编号格式不正确", expression = "^(\\w){4,20}$"),
					@RegexFieldValidator(fieldName = "depart_name", message = "名称格式不正确", expression = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$")})
	public String execute() throws Exception {
		if (department.getId() == null) {
			try {
				departmentService.add(department);
				message = new Message(getText("operate_ok"),"添加部门信息成功！", true, "department_list");
			} catch (BusinessException e) {
				e.printStackTrace();
				message = new Message(getText("operate_fail"),"添加部门信息失败，请重试！<br/>原因："+ e.getMessage(),
						false, null);
			}
		} else {
			try {
				Department dep = departmentService.findClass(Department.class,
						department.getId());
				dep.setDepart_id(department.getDepart_id());
				dep.setDepart_name(department.getDepart_name());
				dep.setDepart_info(department.getDepart_info());
				dep.setVersion(department.getVersion());
				departmentService.update(dep);
				message = new Message(getText("operate_ok"),"修改部门信息成功！", true, "department_list");
			} catch (BusinessException e) {
				e.printStackTrace();
				message = new Message(getText("operate_ok"),"修改部门信息失败，请重试！<br/>原因：" + e.getMessage(),
						false, null);
			}
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public Department getModel() {
		return department;
	}
}
