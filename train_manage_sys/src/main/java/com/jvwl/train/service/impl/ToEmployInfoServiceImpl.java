package com.jvwl.train.service.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.jvwl.train.bean.EmployState;
import com.jvwl.train.bean.InterviewResult;
import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.ToEmployInfoDto;
import com.jvwl.train.model.ToEmployInfo;
import com.jvwl.train.service.ToEmployInfoService;
import com.jvwl.train.service.base.BaseServiceImpl;

/**
 * @author ctt
 * 
 */
@Component("toEmployInfoService")
public class ToEmployInfoServiceImpl extends
		BaseServiceImpl<ToEmployInfo, ToEmployInfoDto> implements
		ToEmployInfoService {

	public Pagination<ToEmployInfo> findObjects(ToEmployInfoDto dto,
			PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
	}

	public Pagination<ToEmployInfo> findObjects(ToEmployInfoDto dto,
			PageInfo pageInfo, Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);
	}

	public String getSqlWhere(ToEmployInfoDto dto) {
		StringBuilder sql = new StringBuilder();
		if (dto == null) {
			return "";
		} else {
			String jobId = dto.getJobId();
			EmployState type = dto.getType();
			String userChinaName = dto.getUserChinaName();
			String preWorkComp = dto.getPreWorkComp();
			InterviewResult interViewResult = dto.getInterViewResult();
			String schoolName = dto.getSchoolName();
			Date comeDate = dto.getComeDate();
			Date comeDate2 = dto.getComeDate2();

			if (null != jobId && !"".equals(jobId)) {
				sql.append(" and e.jobId = '" + jobId + "'");
			}

			if (null != type) {
				sql.append(" and e.type=" + type.ordinal());
			}

			if (null != userChinaName && !"".equals(userChinaName)) {
				sql.append(" and e.userChinaName like '%" + userChinaName
						+ "%'");
			}

			if (null != preWorkComp && !"".equals(preWorkComp)) {
				sql.append(" and e.preWorkComp like '%" + preWorkComp + "%'");
			}

			if (null != interViewResult) {
				sql.append(" and e.interViewResult="
						+ interViewResult.ordinal());
			}

			if (null != schoolName && !"".equals(schoolName)) {
				sql.append(" and e.schoolName like '%" + schoolName + "%'");
			}

			if (null != comeDate && null != comeDate2) {
				sql.append(" and e.comeDate between '" + comeDate + "' and '"
						+ comeDate2 + "'");
			} else if (null != comeDate) {
				sql.append(" and e.comeDate >= '" + comeDate + "'");
			} else if (null != comeDate2) {
				sql.append(" and e.comeDate <= '" + comeDate2 + "'");
			}

			return sql.toString();
		}
	}

}
