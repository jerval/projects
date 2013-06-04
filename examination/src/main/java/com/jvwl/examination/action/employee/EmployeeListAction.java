package com.jvwl.examination.action.employee;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;
import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.EmployeeDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.exception.BusinessException;
import com.jvwl.examination.model.Department;
import com.jvwl.examination.model.Employee;
import com.jvwl.examination.service.IBaseService;
import com.jvwl.examination.service.IEmployeeService;
import com.opensymphony.xwork2.ModelDriven;

@Component("employeeListAction")
@SuppressWarnings("serial")
public class EmployeeListAction extends BaseAction implements SessionAware,
		ModelDriven<EmployeeDTO> {

	private IEmployeeService<Employee> employeeService;
	private IBaseService<Department> baseService;
	private EmployeeDTO employeeDTO = new EmployeeDTO();
	private Pagination<Employee> pagination;
	private List<Department> departments;
	private Map<String, Object> sessionMap;
	private Integer pageNo;
	private Integer pageSize;

	public List<Department> getDepartments() {
		return departments;
	}

	public Pagination<Employee> getPagination() {
		return pagination;
	}

	@Resource
	public void setBaseService(IBaseService<Department> baseService) {
		this.baseService = baseService;
	}

	@Resource
	public void setEmployeeService(IEmployeeService<Employee> employeeService) {
		this.employeeService = employeeService;
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
	public String getDeparts() throws Exception{
		String jpql = "select d.id,d.depart_name from Department d ";
		try {
			departments = baseService.query(jpql, new PageInfo(1, 9999));
		} catch (BusinessException e) {
			e.printStackTrace();
		}	
		return SUCCESS;
	}

	@Override
	@JSON(serialize = false)
	public EmployeeDTO getModel() {
		return employeeDTO;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
