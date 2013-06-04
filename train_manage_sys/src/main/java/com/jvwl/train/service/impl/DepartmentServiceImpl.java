package com.jvwl.train.service.impl;

import org.springframework.stereotype.Component;

import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.DepartmentDto;
import com.jvwl.train.model.Department;
import com.jvwl.train.service.DepartmentService;
import com.jvwl.train.service.base.BaseServiceImpl;

/**
 * DepartmentService实现类
 * 
 * @author hejie
 * 
 */
@Component("departmentService")
public class DepartmentServiceImpl extends
		BaseServiceImpl<Department, DepartmentDto> implements DepartmentService {

	public Pagination<Department> findObjects(DepartmentDto dto,
			PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
	}

	public Pagination<Department> findObjects(DepartmentDto dto,
			PageInfo pageInfo, Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);
	}

	public String getSqlWhere(DepartmentDto dto) {
		StringBuilder sql = new StringBuilder();
		if (dto == null) {
			return "";
		} else {
			String departmentId = dto.getDepartmentId();
			String departmentName = dto.getDepartmentName();
			if (null != departmentId && !"".equals(departmentId)) {
				sql.append(" and e.departmentId = '" + departmentId + "' ");
			}
			if (null != departmentName && !"".equals(departmentName)) {
				sql.append(" and e.departmentName like '%" + departmentName
						+ "%' ");
			}
			return sql.toString();
		}
	}


}
