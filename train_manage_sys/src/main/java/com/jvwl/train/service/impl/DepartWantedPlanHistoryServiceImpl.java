package com.jvwl.train.service.impl;

import org.springframework.stereotype.Component;

import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.DepartWantedPlanHistoryDto;
import com.jvwl.train.model.DepartWantedPlanHistory;
import com.jvwl.train.service.DepartWantedPlanHistoryService;
import com.jvwl.train.service.base.BaseServiceImpl;


/**
 * DepartWantedPlanHistoryService实现类
 * @author hejie
 *
 */
@Component("departWantedPlanHistoryService")
public class DepartWantedPlanHistoryServiceImpl extends
 BaseServiceImpl<DepartWantedPlanHistory, DepartWantedPlanHistoryDto> implements DepartWantedPlanHistoryService{

	public Pagination<DepartWantedPlanHistory> findObjects(
			DepartWantedPlanHistoryDto dto, PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
	}

	public Pagination<DepartWantedPlanHistory> findObjects(
			DepartWantedPlanHistoryDto dto, PageInfo pageInfo, Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);
	}

	public String getSqlWhere(DepartWantedPlanHistoryDto dto) {
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
