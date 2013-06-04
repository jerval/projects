package com.jvwl.examination.service;

import com.jvwl.examination.dto.ExaminationScoreDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.BaseBean;

public interface IExaminationScoreService <T extends BaseBean> extends IBaseService<T>{
	
	public Pagination<T> findExaminationScores(ExaminationScoreDTO eDto,PageInfo pageInfo);
}
