package com.jvwl.service;

import java.io.Serializable;
import java.util.List;

import com.jvwl.dto.DepartmentDTO;
import com.jvwl.dto.PageInfo;
import com.jvwl.dto.Pagination;
import com.jvwl.model.Department;

public class DepartmentService extends BaseService<Department> {

	public Department findByDepartId(String id) {
		String jpql = "from Department d where d.depart_id=?";
		List<Department> list = query(jpql, null, new Object[] { id });
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public Department find( Serializable id) {
		return super.find(Department.class, id);
	}
	
	public Department findClass(Serializable id) {
		return super.findClass(Department.class, id);
	}
	
	public void delete(Serializable[] ids) {
		super.delete(Department.class, ids);
	}
	public List<Department> findDepartments() {
		List<Department> list = query("from Department ", null);
		return list;
	}

	public Pagination<Department> findDepartments(DepartmentDTO dep, PageInfo pageInfo) {
		String sqlWhere = getSQL(dep);
		String jpql = " from Department d where 1=1 " + sqlWhere
				+ " order by d.id desc";
		List<Department> list = query(jpql, pageInfo);
		jpql = " select count(*) from Department d where 1=1 " + sqlWhere;
		long maxElements = getTotalElements(jpql);
		Pagination<Department> pagination = new Pagination<Department>(null, maxElements,
				pageInfo.getPageNo(), pageInfo.getPageSize());
		if (maxElements > 0) {
			pagination.setList(list);
		}
		return pagination;
	}

	private String getSQL(DepartmentDTO dep) {
		StringBuilder sql = new StringBuilder();
		if (dep == null) {
			return "";
		} else {
			String id = dep.getDepart_id();
			String name = dep.getDepart_name();
			if (null != id && !"".equals(id)) {
				sql.append(" and d.depart_id like '%" + dep.getDepart_id()
						+ "%'");
			}
			if (null != name && !"".equals(name)) {
				sql.append(" and d.depart_name like '%" + name + "%'");
			}
			return sql.toString();
		}
	}
}
