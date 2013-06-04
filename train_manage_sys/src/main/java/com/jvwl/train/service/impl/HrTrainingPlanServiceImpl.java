package com.jvwl.train.service.impl;

import org.springframework.stereotype.Component;

import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.HrTrainingPlanDto;
import com.jvwl.train.model.HrTrainingPlan;
import com.jvwl.train.service.HrTrainingPlanService;
import com.jvwl.train.service.base.BaseServiceImpl;
/**
 * @author 罗鸿伟
 *
 */
@Component("hrTrainingPlanService")
public class HrTrainingPlanServiceImpl  extends
BaseServiceImpl<HrTrainingPlan, HrTrainingPlanDto> implements HrTrainingPlanService {

	public Pagination<HrTrainingPlan> findObjects(HrTrainingPlanDto dto,
			PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
		
	}

	public Pagination<HrTrainingPlan> findObjects(HrTrainingPlanDto dto,
			PageInfo pageInfo, Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);
	}

	public String getSqlWhere(HrTrainingPlanDto dto) {
		StringBuilder sql = new StringBuilder();
		if (dto == null) {
			return "";
		} else {
			String trainingplanSeq = dto.getTrainingplanSeq();
			String planName = dto.getPlanName();
			String userChinaname = dto.getUserChinaname();
			String trainingType = dto.getTrainingType();
			String planexecFlag = dto.getPlanexecFlag();
			if (null != trainingplanSeq && !"".equals(trainingplanSeq)) {
				sql.append(" and e.trainingplanSeq like '%" + trainingplanSeq + "%'");
			}
			if (null != planName && !"".equals(planName)) {
				sql.append(" and e.planName like '%" + planName + "%'");
			}
			if (null != userChinaname && !"".equals(userChinaname)) {
				sql.append(" and e.stsff.userChinaname like '%" + userChinaname + "%'");
			}
			if (null != trainingType && !"".equals(trainingType)) {
				sql.append(" and e.trainingType like '%" + trainingType + "%'");
			}
			if (null != planexecFlag && !"".equals(planexecFlag)) {
				sql.append(" and e.planexecFlag like '%" + planexecFlag + "%'");
			}
			return sql.toString();
		}
	}

}
