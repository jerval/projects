package com.jvwl.action.department;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.jvwl.action.BaseAction;
import com.jvwl.dto.DepartmentDTO;
import com.jvwl.dto.PageInfo;
import com.jvwl.dto.Pagination;
import com.jvwl.model.Department;
import com.jvwl.service.DepartmentService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ListAction extends BaseAction implements SessionAware,
		ModelDriven<DepartmentDTO> {

	private DepartmentService departmentService = new DepartmentService();
	private DepartmentDTO departmentDTO = new DepartmentDTO();
	private Pagination<Department> pagination;
	private Map<String, Object> sessionMap;
	private Integer pageNo;
	private Integer pageSize;

	public Pagination<Department> getPagination() {
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
		if (pageNo == null) {
			pageNo = 1;
		}
		if (sessionMap.get("pageSize") == null) {
			sessionMap.put("pageSize", 10);
		} else if (pageSize != null) {
			sessionMap.put("pageSize", pageSize);
		}
		pagination = departmentService.findDepartments(departmentDTO,
				new PageInfo(pageNo, (Integer) sessionMap.get("pageSize")));
		return SUCCESS;
	}

	@JSON(serialize = false)
	public DepartmentDTO getModel() {
		return departmentDTO;
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
