package com.jvwl.examination.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jvwl.examination.dto.ExaminationScoreDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.BaseBean;
import com.jvwl.examination.service.IExaminationScoreService;

@Component("examinationScoreService")
public class ExaminationScoreServiceImpl<T extends BaseBean> extends
		BaseServiceImpl<T> implements IExaminationScoreService<T> {

	private String getSQL(ExaminationScoreDTO eDto) {
		StringBuilder sql = new StringBuilder();
		if (eDto == null) {
			return "";
		} else {
			String employee_id = eDto.getEmployee_id();
			String paper_id = eDto.getPaper_id();
			String date1 = eDto.getDate1();
			String date2 = eDto.getDate2();
			Integer answerTime1 = eDto.getAnswerTime1();
			Integer answerTime2 = eDto.getAnswerTime2();
			Float score1 = eDto.getScore1();
			Float score2 = eDto.getScore2();
			if (null != employee_id && !"".equals(employee_id)) {
				sql.append(" and e.employee.emp_id like '%" + employee_id
						+ "%'");
			}
			if (null != paper_id && !"".equals(paper_id)) {
				sql.append(" and e.paper.paper_id like '%" + paper_id + "%'");
			}

			if (null != date1 && null != date2) {
				sql.append(" and e.date between " + date1 + " and " + date2);
			} else if (null != date1 && null == date2) {
				sql.append(" and e.date >= " + date1);
			} else if (null == date1 && null != date2) {
				sql.append(" and e.date <= " + date2);
			}

			if (null != answerTime1 && null != answerTime2) {
				sql.append(" and e.answerTime between " + answerTime1 + " and "
						+ answerTime2);
			} else if (null != answerTime1 && null == answerTime2) {
				sql.append(" and e.answerTime >= " + answerTime1);
			} else if (null == answerTime1 && null != answerTime2) {
				sql.append(" and e.answerTime <= " + answerTime2);
			}
			
			if (null != score1 && null != score2) {
				sql.append(" and e.score between " + score1 + " and "
						+ answerTime2);
			} else if (null != score1 && null == score2) {
				sql.append(" and e.score >= " + score1);
			} else if (null == score1 && null != score2) {
				sql.append(" and e.score <= " + score2);
			}

			return sql.toString();
		}
	}

	@Override
	public Pagination<T> findExaminationScores(ExaminationScoreDTO eDto,
			PageInfo pageInfo) {
		String sqlWhere = getSQL(eDto);
		String jpql = " from ExaminationScore e where 1=1 " + sqlWhere+ " order by e.id desc";
		List<T> list = query(jpql, pageInfo);
		jpql = " select count(*) from ExaminationScore e where 1=1 " + sqlWhere;
		long maxElements = getTotalElements(jpql);
		Pagination<T> pagination = new Pagination<T>(null, maxElements,
				pageInfo.getPageNo(), pageInfo.getPageSize());
		if (maxElements > 0) {
			pagination.setList(list);
		}
		return pagination;
	}
}
