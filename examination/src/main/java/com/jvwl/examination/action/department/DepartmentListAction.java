package com.jvwl.examination.action.department;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.DepartmentDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.Department;
import com.jvwl.examination.service.IDepartmentService;
import com.opensymphony.xwork2.ModelDriven;

@Component("departmentListAction")
@SuppressWarnings("serial")
public class DepartmentListAction extends BaseAction implements SessionAware,
		ModelDriven<DepartmentDTO> {

	private IDepartmentService<Department> departmentService;
	private DepartmentDTO departmentDTO = new DepartmentDTO();
	private Pagination<Department> pagination;
	private Map<String, Object> sessionMap;
	private Integer pageNo;
	private Integer pageSize;

	public Pagination<Department> getPagination() {
		return pagination;
	}

	@Resource
	public void setDepartmentService(
			IDepartmentService<Department> departmentService) {
		this.departmentService = departmentService;
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

	@Override
	@JSON(serialize = false)
	public DepartmentDTO getModel() {
		return departmentDTO;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
