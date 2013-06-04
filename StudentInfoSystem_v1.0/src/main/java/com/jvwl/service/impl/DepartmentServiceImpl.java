package com.jvwl.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.jvwl.bean.Pagination;
import com.jvwl.dao.ObjectDao;
import com.jvwl.model.Department;
import com.jvwl.service.DepartmentService;

public class DepartmentServiceImpl extends BaseServiceImpl implements DepartmentService {
	private ObjectDao<Department> departmentDao;

	public void setDepartmentDao(ObjectDao<Department> departmentDao) {
		this.departmentDao = departmentDao;
	}

	public void addDepartment(Department department, String username) {
		departmentDao.existObject(Department.class, department.getDepartmentId());
		departmentDao.addObject(department);
		saveLog(username, "添加系别：" + department.getDepartmentId());
	}

	public void updateDepartment(Department department, String username) {
		departmentDao.updateObject(department);
		saveLog(username, "修改系别：" + department.getDepartmentId());
	}

	public void deleteDepartment(List<Serializable> ids, String username) {
		departmentDao.deleteObjects(Department.class, ids);
		saveLog(username, "删除系别：" + ids);
	}

	public Department findDepartment(String id) {
		return departmentDao.findObject(Department.class, id);
	}

	public Pagination<Department> findDepartments(Map<String, Object> map,
			int pageNum, int pageSize) {
		return departmentDao.findObjects(Department.class, map, pageNum,
				pageSize);
	}

}
