package com.jvwl.examination.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jvwl.examination.bean.PaperType;
import com.jvwl.examination.bean.YesNo;
import com.jvwl.examination.dto.ExaminationQuestionDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.BaseBean;
import com.jvwl.examination.service.IExaminationQuestionService;

@Component("examinationQuestionService")
public class ExaminationQuestionServiceImpl<T extends BaseBean> extends
		BaseServiceImpl<T> implements IExaminationQuestionService<T> {

	private String getSQL(ExaminationQuestionDTO eDto) {
		StringBuilder sql = new StringBuilder();
		if (eDto == null) {
			return "";
		} else {
			String id = eDto.getQuestion_id();
			String paper_id = eDto.getPaper().getPaper_id();
			PaperType type = eDto.getQuestionType();
			Float score1 = eDto.getScore1();
			Float score2 = eDto.getScore2();
			YesNo state = eDto.getState();
			if (null != id && !"".equals(id)) {
				sql.append(" and e.question_id like '%" + id + "%'");
			}
			if (null != paper_id && !"".equals(paper_id)) {
				sql.append(" and e.paper.paper_id like '%" + paper_id + "%'");
			}
			if (null != type && !"".equals(type.name())) {
				sql.append(" and e.questionType ='" + type.name() + "'");
			}
			if (null != score1 && null != score2) {
				sql.append(" and e.score between " + score1 + " and " + score2);
			} else if (null != score1 && null == score2) {
				sql.append(" and e.score >= " + score1);
			} else if (null == score1 && null != score2) {
				sql.append(" and e.score <= " + score2);
			}
			if (null != state && !"".equals(state.name())) {
				sql.append(" and e.state ='" + state.name() + "'");
			}
			return sql.toString();
		}
	}

	@Override
	public T findByQuestionId(String id) {
		String jpql = "from ExaminationQuestion e where e.question_id=?";
		List<T> list = query(jpql, new PageInfo(1, 1), new Object[] { id });
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Pagination<T> findExaminationQuestions(ExaminationQuestionDTO eDto,
			PageInfo pageInfo) {
		String sqlWhere = getSQL(eDto);
		String jpql = " from ExaminationQuestion e where 1=1 " + sqlWhere
				+ " order by e.id desc";
		List<T> list = query(jpql, pageInfo);
		jpql = " select count(*) from ExaminationQuestion e where 1=1 "
				+ sqlWhere;
		long maxElements = getTotalElements(jpql);
		Pagination<T> pagination = new Pagination<T>(null, maxElements,
				pageInfo.getPageNo(), pageInfo.getPageSize());
		if (maxElements > 0) {
			pagination.setList(list);
		}
		return pagination;
	}

	@Override
	public Pagination<T> findExaminationQuestionsByPaperId(String paperId,
			PageInfo pageInfo) {
		String jpql = " from ExaminationQuestion e where 1=1 and e.paper.paper_id='"
				+ paperId + "' order by e.id desc";
		List<T> list = query(jpql, pageInfo);
		jpql = " select count(*) from ExaminationQuestion e where 1=1  and e.paper.paper_id='"
				+ paperId + "'";
		long maxElements = getTotalElements(jpql);
		Pagination<T> pagination = new Pagination<T>(null, maxElements,
				pageInfo.getPageNo(), pageInfo.getPageSize());
		if (maxElements > 0) {
			pagination.setList(list);
		}
		return pagination;
	}
}
