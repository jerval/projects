package com.jvwl.action;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.jvwl.bean.Pagination;
import com.jvwl.model.Department;
import com.jvwl.model.User;
import com.jvwl.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements
		ModelDriven<Department>, SessionAware {
	private static final long serialVersionUID = 4233464072288035445L;
	private DepartmentService departmentService;
	private Department department=new Department();
	private Map<String, Object> session;
	private ByteArrayInputStream inputStream;
	private int pageSize=20;
	private int pageNum=1;
	private Pagination<Department> pagination;

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public String getOperateUserName() {
		return ((User) session.get("user")).getUsername();
	}

	public String add() {
		return "add";
	}

	public String addSave() {
		departmentService.addDepartment(department, getOperateUserName());
		inputStream = new ByteArrayInputStream("success添加".getBytes());
		return "text";
	}

	public String update() {
		department = departmentService.findDepartment(department.getDepartmentId());
		return "update";
	}

	public String updateSave() {
		departmentService.updateDepartment(department, getOperateUserName());
		inputStream = new ByteArrayInputStream("success修改".getBytes());
		return "text";
	}

	public String delete() {
		List<Serializable> ids = new ArrayList<Serializable>();
		ids.add(department.getDepartmentId());System.out.println(ids);
		departmentService.deleteDepartment(ids, getOperateUserName());
		findAll();
		return "pagination";
	}

	public String findOne() {
		department = departmentService.findDepartment(department.getDepartmentId());
		return "department";
	}

	public String findAll() {
		pagination = departmentService.findDepartments(null, pageNum, pageSize);
		return "pagination";
	}

	@Override
	public Department getModel() {
		return department;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public Pagination<Department> getPagination() {
		return pagination;
	}
}
