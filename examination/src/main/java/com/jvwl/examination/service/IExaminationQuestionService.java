package com.jvwl.examination.service;

import com.jvwl.examination.dto.ExaminationQuestionDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.BaseBean;

public interface IExaminationQuestionService <T extends BaseBean> extends IBaseService<T>{

	public T findByQuestionId(String id);

	public Pagination<T> findExaminationQuestions(ExaminationQuestionDTO eDto,PageInfo pageInfo);
	
	public Pagination<T> findExaminationQuestionsByPaperId(String paper_id,PageInfo pageInfo);
}
