package com.jvwl.examination.service;

import com.jvwl.examination.dto.ExaminationPaperDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.BaseBean;

public interface IExaminationPaperService <T extends BaseBean> extends IBaseService<T>{

	public T findByPaperId(String id);

	public Pagination<T> findExaminationPapers(ExaminationPaperDTO eDto,PageInfo pageInfo);
	
	public Pagination<T> findExaminationPapersByDepartId(String depart_id,PageInfo pageInfo);
}
