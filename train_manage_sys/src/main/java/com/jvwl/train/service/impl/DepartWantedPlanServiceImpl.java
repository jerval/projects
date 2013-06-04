package com.jvwl.train.service.impl;

import org.springframework.stereotype.Component;

import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.DepartWantedPlanDto;
import com.jvwl.train.model.DepartWantedPlan;
import com.jvwl.train.service.DepartWantedPlanService;
import com.jvwl.train.service.base.BaseServiceImpl;

/**
 * DepartWantedPlanService实现类
 * @author hejie
 *
 */
@Component("departWantedPlanService")
public class DepartWantedPlanServiceImpl extends
BaseServiceImpl<DepartWantedPlan, DepartWantedPlanDto> implements DepartWantedPlanService{

	public Pagination<DepartWantedPlan> findObjects(DepartWantedPlanDto dto,
			PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
	}

	public Pagination<DepartWantedPlan> findObjects(DepartWantedPlanDto dto,
			PageInfo pageInfo, Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);
	}

	public String getSqlWhere(DepartWantedPlanDto dto) {
		StringBuilder sql = new StringBuilder();
		if (dto == null) {
			return "";
		}else{
			String year=dto.getYear();
			String departmentId=dto.getDepartmentId();
			if(null !=year && !"".equals(year)){
				sql.append(" and e.year like '%"+year+"%' ");
			}
			if(null !=departmentId && !"".equals(departmentId)){
				sql.append(" and e.department.departmentId = '"+departmentId+"'");
			}
			return sql.toString();
		}
	}
}
