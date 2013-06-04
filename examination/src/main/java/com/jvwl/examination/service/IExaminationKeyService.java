package com.jvwl.examination.service;

import com.jvwl.examination.dto.ExaminationKeyDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.BaseBean;

public interface IExaminationKeyService <T extends BaseBean> extends IBaseService<T>{

	public Pagination<T> findExaminationKeys(ExaminationKeyDTO eDto,PageInfo pageInfo);
}
