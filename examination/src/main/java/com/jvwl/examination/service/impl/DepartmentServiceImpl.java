package com.jvwl.examination.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jvwl.examination.dto.DepartmentDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.BaseBean;
import com.jvwl.examination.service.IDepartmentService;

@Component("departmentService")
public class DepartmentServiceImpl<T extends BaseBean> extends
		BaseServiceImpl<T> implements IDepartmentService<T> {

	@Override
	public T findByDepartId(String id) {
		String jpql = "from Department d where d.depart_id=?";
		List<T> list = query(jpql, new PageInfo(1, 1), new Object[] { id });
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Pagination<T> findDepartments(DepartmentDTO dep, PageInfo pageInfo) {
		String sqlWhere = getSQL(dep);
		String jpql = " from Department d where 1=1 " + sqlWhere
				+ " order by d.id desc";
		List<T> list = query(jpql, pageInfo);
		jpql = " select count(*) from Department d where 1=1 " + sqlWhere;
		long maxElements = getTotalElements(jpql);
		Pagination<T> pagination = new Pagination<T>(null, maxElements,
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
