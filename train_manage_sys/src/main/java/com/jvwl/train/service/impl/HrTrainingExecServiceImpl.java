package com.jvwl.train.service.impl;

import org.springframework.stereotype.Component;

import com.jvwl.train.bean.YesNo;
import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.HrTrainingExecDto;
import com.jvwl.train.model.HrTrainingExec;
import com.jvwl.train.service.HrTrainingExecService;
import com.jvwl.train.service.base.BaseServiceImpl;
/**
 * @author 王长江
 *
 */
@Component("hrTrainingExecService")
public class HrTrainingExecServiceImpl extends
BaseServiceImpl<HrTrainingExec, HrTrainingExecDto> implements HrTrainingExecService {

	public Pagination<HrTrainingExec> findObjects(HrTrainingExecDto dto,
			PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
	}

	public Pagination<HrTrainingExec> findObjects(HrTrainingExecDto dto,
			PageInfo pageInfo, Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);

	}

	public String getSqlWhere(HrTrainingExecDto dto) {
		StringBuilder sql = new StringBuilder();
		if (dto == null) {
			return "";
		} else {
			
			String trainingexecSeq = dto.getTrainingexecSeq();
			String courceName=dto.getCourceName();
			String courceManager=dto.getCourceManager();
			YesNo okFlag=dto.getOkFlag();
			String insertID=dto.getInsertID();
			String updateID=dto.getUpdateID();
			YesNo deleteFlag=dto.getDeleteFlag();
			
			
			
			if (null != trainingexecSeq && !"".equals(trainingexecSeq)) {
				sql.append(" and e.trainingexecSeq=" + trainingexecSeq);
			}
			if (null != courceName && !"".equals(courceName)) {
				sql.append(" and e.courceName like '%" + courceName
						+ "%'");
			}
			if (null != courceManager && !"".equals(courceManager)) {
				sql.append(" and e.courceManager like '%" + courceManager
						+ "%'");
			}
		
			if (null != okFlag) {
				sql.append(" and e.execFlag=" + okFlag.ordinal()
						);
			}
			
			if (null != insertID && !"".equals(insertID)) {
				sql.append(" and e.insertID =" + insertID
						);
			}
			if (null != updateID && !"".equals(updateID)) {
				sql.append(" and e.updateID like '%" + updateID
						);
			}
			if (null != deleteFlag && !"".equals(deleteFlag)) {
				sql.append(" and e.deleteFlag=" + deleteFlag
						);
			}
			return sql.toString();
		}
	}

}
