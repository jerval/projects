package com.jvwl.train.service.impl;

import org.springframework.stereotype.Component;

import com.jvwl.train.bean.YesNo;
import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.HrTrainingExecDetailDto;
import com.jvwl.train.model.HrTrainingExecDetail;
import com.jvwl.train.service.HrTrainingExecDetailService;
import com.jvwl.train.service.base.BaseServiceImpl;

/**
 * @author 王长江
 * 
 */
@Component("hrTrainingExecDetailService")
public class HrTrainingExecDetailServiceImpl extends
		BaseServiceImpl<HrTrainingExecDetail, HrTrainingExecDetailDto>
		implements HrTrainingExecDetailService {

	public Pagination<HrTrainingExecDetail> findObjects(
			HrTrainingExecDetailDto dto, PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
	}

	public Pagination<HrTrainingExecDetail> findObjects(
			HrTrainingExecDetailDto dto, PageInfo pageInfo, Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);
	}

	public String getSqlWhere(HrTrainingExecDetailDto dto) {
		StringBuilder sql = new StringBuilder();
		if (dto == null) {
			return "";
		} else {
			String execsubNO = dto.getExecsubNO();
			String companytrainName = dto.getCompanytrainName();
			String companytrainManager = dto.getCompanytrainManager();
			YesNo execFlag = dto.getExecFlag();

			if (null != execsubNO && !"".equals(execsubNO)) {
				sql.append(" and e.execsubNO like '%" + execsubNO+"%'");
			}
			if (null != companytrainName && !"".equals(companytrainName)) {
				sql.append(" and e.companytrainName like '%" + companytrainName
						+ "%'");
			}
			if (null != companytrainManager && !"".equals(companytrainManager)) {
				sql.append(" and e.companytrainManager like '%"
						+ companytrainManager + "%'");
			}

			if (null != execFlag) {
				sql.append(" and e.execFlag=" + execFlag.ordinal());
			}

			return sql.toString();
		}
	}

}
