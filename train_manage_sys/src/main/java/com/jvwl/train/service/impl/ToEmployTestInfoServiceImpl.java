package com.jvwl.train.service.impl;

import org.springframework.stereotype.Component;

import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.ToEmployTestInfoDto;
import com.jvwl.train.model.ToEmployTestInfo;
import com.jvwl.train.service.ToEmployTestInfoService;
import com.jvwl.train.service.base.BaseServiceImpl;

/**
 * @author ctt
 * 
 */
@Component("toEmployTestInfoService")
public class ToEmployTestInfoServiceImpl extends
		BaseServiceImpl<ToEmployTestInfo, ToEmployTestInfoDto> implements
		ToEmployTestInfoService {

	public Pagination<ToEmployTestInfo> findObjects(ToEmployTestInfoDto dto,
			PageInfo pageInfo) {
		return findEntities(getSqlWhere(dto), pageInfo);
	}

	public Pagination<ToEmployTestInfo> findObjects(ToEmployTestInfoDto dto,
			PageInfo pageInfo, Boolean deleted) {
		return findEntities(getSqlWhere(dto), pageInfo, deleted);
	}

	public String getSqlWhere(ToEmployTestInfoDto dto) {
		return "";
	}

}
