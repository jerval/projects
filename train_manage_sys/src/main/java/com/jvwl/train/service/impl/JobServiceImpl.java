package com.jvwl.train.service.impl;

import org.springframework.stereotype.Component;

import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.JobDto;
import com.jvwl.train.model.Job;
import com.jvwl.train.service.JobService;
import com.jvwl.train.service.base.BaseServiceImpl;

/**
 * @author liuxin
 * 
 */
@Component("jobService")
public class JobServiceImpl extends BaseServiceImpl<Job, JobDto> implements
		JobService {

	public Pagination<Job> findObjects(JobDto dto, PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
	}

	public Pagination<Job> findObjects(JobDto dto, PageInfo pageInfo,
			Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);
	}

	public String getSqlWhere(JobDto dto) {
		StringBuilder sql = new StringBuilder();
		if (dto == null) {
			return "";
		} else {
			String jobId = dto.getJobId();
			String jobName = dto.getJobName();
			String jobShortName = dto.getJobShortName();
			if (null != jobId && !"".equals(jobId)) {
				sql.append(" and e.jobId like '%" + jobId + "%'");
			}
			if (null != jobName && !"".equals(jobName)) {
				sql.append(" and e.jobName like '%" + jobName + "%'");
			}
			if (null != jobShortName && !"".equals(jobShortName)) {
				sql.append(" and e.jobShortName like '%" + jobShortName + "%'");
			}
			return sql.toString();
		}
	}

}
