package com.jvwl.action.employee;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.jvwl.action.BaseAction;
import com.jvwl.dto.EmployeeDTO;
import com.jvwl.dto.PageInfo;
import com.jvwl.dto.Pagination;
import com.jvwl.model.Employee;
import com.jvwl.service.EmployeeService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ListAction extends BaseAction implements SessionAware,
		ModelDriven<EmployeeDTO> {

	private EmployeeService employeeService = new EmployeeService();
	
	private EmployeeDTO employeeDTO = new EmployeeDTO();
	private Pagination<Employee> pagination;
	private Map<String, Object> sessionMap;
	private Integer pageNo;
	private Integer pageSize;

	public Pagination<Employee> getPagination() {
		return pagination;
	}
	
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	@JSON(serialize = false)
	public String execute() throws Exception {
		if (pageNo == null||"".equals(pageNo)) {
			pageNo = 1;
		}
		if (sessionMap.get("pageSize") == null) {
			sessionMap.put("pageSize", 10);
		} else if (pageSize != null) {
			sessionMap.put("pageSize", pageSize);
		}
		pagination = employeeService.findEmployees(employeeDTO, new PageInfo(
				pageNo, (Integer) sessionMap.get("pageSize")));
		return SUCCESS;
	}

	@JSON(serialize = false)
	public EmployeeDTO getModel() {
		return employeeDTO;
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
