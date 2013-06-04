package com.jvwl.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.jvwl.bean.Pagination;
import com.jvwl.model.Department;

public interface DepartmentService {

	public void addDepartment(Department department, String username);

	public void updateDepartment(Department department, String username);

	public void deleteDepartment(List<Serializable> ids, String username);

	public Department findDepartment(String id);

	public Pagination<Department> findDepartments(Map<String, Object> map,
			int pageNum, int pageSize);

}