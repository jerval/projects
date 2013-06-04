package com.jvwl.train.service.impl;

import org.springframework.stereotype.Component;

import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.HrTrainingExecUserFeedbackDto;
import com.jvwl.train.model.HrTrainingExecUserFeedback;
import com.jvwl.train.service.HrTrainingExecUserFeedbackService;
import com.jvwl.train.service.base.BaseServiceImpl;

/**
 * @author 王长江
 * 
 */
@Component("hrTrainingExecUserFeedbackService")
public class HrTrainingExecUserFeedbackServiceImpl
		extends
		BaseServiceImpl<HrTrainingExecUserFeedback, HrTrainingExecUserFeedbackDto>
		implements HrTrainingExecUserFeedbackService {

	public Pagination<HrTrainingExecUserFeedback> findObjects(
			HrTrainingExecUserFeedbackDto dto, PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
	}

	public Pagination<HrTrainingExecUserFeedback> findObjects(
			HrTrainingExecUserFeedbackDto dto, PageInfo pageInfo,
			Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);

	}

	public String getSqlWhere(HrTrainingExecUserFeedbackDto dto) {
		StringBuilder sql = new StringBuilder();
		if (dto == null) {
			return "";
		} else {
			String jobName = dto.getJob().getJobName();
			String staffName = dto.getStaff().getAlamName();
			String needsitinFlag = dto.getNeedsitinFlag();
			String sitinFlag = dto.getSitinFlag();
			String trainingCounter = dto.getTrainingCounter();
			String insertID = dto.getInsertID();
			if (null != jobName && !"".equals(jobName)) {
				sql.append(" and e.jobName=" + jobName);
			}
			if (null != staffName && !"".equals(staffName)) {
				sql.append(" and e.staffName=" + staffName);
			}
			if (null != needsitinFlag && !"".equals(needsitinFlag)) {
				sql.append(" and e.needsitinFlag=" + needsitinFlag);
			}
			if (null != sitinFlag && !"".equals(sitinFlag)) {
				sql.append(" and e.sitinFlag =" + sitinFlag);
			}
			if (null != trainingCounter && !"".equals(trainingCounter)) {
				sql.append(" and e.trainingCounter =" + trainingCounter);
			}

			if (null != insertID && !"".equals(insertID)) {
				sql.append(" and e.insertID =" + insertID);
			}

			return sql.toString();
		}
	}

}
