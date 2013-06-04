package com.jvwl.examination.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jvwl.examination.bean.YesNo;
import com.jvwl.examination.dto.ExaminationKeyDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.BaseBean;
import com.jvwl.examination.service.IExaminationKeyService;

@Component("examinationKeyService")
public class ExaminationKeyServiceImpl<T extends BaseBean> extends
		BaseServiceImpl<T> implements IExaminationKeyService<T> {

	@Override
	public Pagination<T> findExaminationKeys(ExaminationKeyDTO eDto,
			PageInfo pageInfo) {
		String sqlWhere = getSQL(eDto);
		String jpql = " from ExaminationKey e where 1=1 " + sqlWhere
				+ " order by e.id desc";
		List<T> list = query(jpql, pageInfo);
		jpql = " select count(*) from ExaminationKey e where 1=1 " + sqlWhere;
		long maxElements = getTotalElements(jpql);
		Pagination<T> pagination = new Pagination<T>(null, maxElements,
				pageInfo.getPageNo(), pageInfo.getPageSize());
		if (maxElements > 0) {
			pagination.setList(list);
		}
		return pagination;
	}

	private String getSQL(ExaminationKeyDTO eDto) {
		StringBuilder sql = new StringBuilder();
		if (eDto == null) {
			return "";
		} else {
			String question_id = eDto.getQuestion_id();
			YesNo state = eDto.getState();
			YesNo correct = eDto.getCorrect();
			if (null != question_id && !"".equals(question_id)) {
				sql.append(" and e.question.id = '" + question_id + "'");
			}
			if (null != state && !"".equals(state.name())) {
				sql.append(" and e.state ='" + state.name() + "'");
			}
			if (null != correct && !"".equals(correct.name())) {
				sql.append(" and e.correct ='" + correct.name() + "'");
			}
			return sql.toString();
		}
	}
}
