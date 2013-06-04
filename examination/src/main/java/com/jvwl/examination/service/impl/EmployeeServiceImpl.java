package com.jvwl.examination.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jvwl.examination.bean.EmployeeLevel;
import com.jvwl.examination.bean.Gender;
import com.jvwl.examination.bean.YesNo;
import com.jvwl.examination.dto.EmployeeDTO;
import com.jvwl.examination.dto.LoginInfo;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.BaseBean;
import com.jvwl.examination.model.Department;
import com.jvwl.examination.service.IEmployeeService;

@Component("employeeService")
public class EmployeeServiceImpl<T extends BaseBean> extends BaseServiceImpl<T>
		implements IEmployeeService<T> {

	@Override
	public T findByEmployeeId(String id) {
		String jpql = "from Employee e where e.emp_id=?";
		List<T> list = query(jpql, new PageInfo(1, 1), new Object[] { id });
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public T login(LoginInfo loginInfo) {
		String jpql = " from Employee e where e.emp_id=? and e.password=? ";
		List<T> list = query(jpql, new PageInfo(1, 1), new Object[] {
			loginInfo.getUsername(), loginInfo.getPassword()});
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public Pagination<T> findEmployees(EmployeeDTO emp, PageInfo pageInfo) {
		String sqlWhere = getSQL(emp);
		String jpql = " from Employee e where 1=1 " + sqlWhere
				+ " order by e.id desc";
		List<T> list = query(jpql, pageInfo);
		jpql = " select count(*) from Employee e where 1=1 " + sqlWhere;
		long maxElements = getTotalElements(jpql);
		Pagination<T> pagination = new Pagination<T>(null, maxElements,
				pageInfo.getPageNo(), pageInfo.getPageSize());
		if (maxElements > 0) {
			pagination.setList(list);
		}
		return pagination;
	}

	private String getSQL(EmployeeDTO emp) {
		StringBuilder sql = new StringBuilder();
		if (emp == null) {
			return "";
		} else {
			String id = emp.getEmp_id();
			String name = emp.getEmp_name();
			Gender gender = emp.getGender();
			Department department = emp.getDepartment();
			EmployeeLevel level = emp.getLevel();
			String email = emp.getEmail();
			String phone = emp.getPhone();
			YesNo dep_manager = emp.getDep_manager();
			String birthday1 = emp.getBirthday1();
			String birthday2 = emp.getBirthday2();
			if (null != id && !"".equals(id)) {
				sql.append(" and e.emp_id like '%" + id + "%'");
			}
			if (null != name && !"".equals(name)) {
				sql.append(" and e.depart_name like '%" + name + "%'");
			}
			if (null != gender && !"".equals(gender.name())) {
				sql.append(" and e.gender = '" + gender.name() + "'");
			}
			if (null != department && !"".equals(department.getDepart_id())) {
				sql.append(" and e.department.id  = '"
						+ department.getDepart_id() + "'");
			}
			if (null != email && !"".equals(email)) {
				sql.append(" and e.depart_name like '%" + email + "%'");
			}
			if (null != phone && !"".equals(phone)) {
				sql.append(" and e.gender like '%" + phone + "%'");
			}
			if (null != dep_manager && !"".equals(dep_manager.name())) {
				sql
						.append(" and e.dep_manager  = '" + dep_manager.name()
								+ "'");
			}

			if (null != birthday1 && null != birthday2 && !"".equals(birthday1)
					&& !"".equals(birthday2)) {
				sql.append(" and e.birthday between '" + birthday1 + "' and '"
						+ birthday2 + "'");
			} else if (null != birthday1 && !"".equals(birthday1)
					&& (null == birthday2 || "".equals(birthday2))) {
				sql.append(" and e.birthday >= '" + birthday1 + "'");
			} else if (null != birthday2 && !"".equals(birthday2)
					&& (null == birthday1 || "".equals(birthday1))) {
				sql.append(" and e.birthday <= '" + birthday2 + "'");
			}
			if (null != level && !"".equals(level)) {
				sql.append(" and e.level ='" + level + "'");
			}
			return sql.toString();
		}
	}
}