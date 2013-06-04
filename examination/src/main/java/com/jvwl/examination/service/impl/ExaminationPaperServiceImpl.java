package com.jvwl.examination.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jvwl.examination.bean.YesNo;
import com.jvwl.examination.dto.ExaminationPaperDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.BaseBean;
import com.jvwl.examination.service.IExaminationPaperService;

@Component("examinationPaperService")
public class ExaminationPaperServiceImpl<T extends BaseBean> extends
		BaseServiceImpl<T> implements IExaminationPaperService<T> {

	private String getSQL(ExaminationPaperDTO eDto) {
		StringBuilder sql = new StringBuilder();
		if (eDto == null) {
			return "";
		} else {
			String paper_id = eDto.getPaper_id();
			String paper_name = eDto.getPaper_name();
			String department_id = eDto.getDepartment().getDepart_id();
			Integer answerTime1 = eDto.getAnswerTime1();
			Integer answerTime2 = eDto.getAnswerTime2();
			YesNo state = eDto.getState();
			if (null != paper_id && !"".equals(paper_id)) {
				sql.append(" and e.paper_id like '%" + paper_id + "%'");
			}
			if (null != paper_name && !"".equals(paper_name)) {
				sql.append(" and e.paper_name like '%" + paper_name + "%'");
			}
			if (null != department_id && !"".equals(department_id)) {
				sql.append(" and e.department.depart_id like '%"
						+ department_id + "%'");
			}
			if (null != answerTime1 && null != answerTime2) {
				sql.append(" and e.answerTime between " + answerTime1 + " and "
						+ answerTime2);
			} else if (null != answerTime1 && null == answerTime2) {
				sql.append(" and e.answerTime >= " + answerTime1);
			} else if (null == answerTime1 && null != answerTime2) {
				sql.append(" and e.answerTime <= " + answerTime2);
			}
			if (null != state && !"".equals(state.name())) {
				sql.append(" and e.state ='" + state.name() + "'");
			}
			return sql.toString();
		}
	}

	@Override
	public T findByPaperId(String id) {
		String jpql = "from ExaminationPaper e where e.paper_id=?";
		List<T> list = query(jpql, new PageInfo(1, 1), new Object[] { id });
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Pagination<T> findExaminationPapers(ExaminationPaperDTO eDto,
			PageInfo pageInfo) {
		String sqlWhere = getSQL(eDto);
		String jpql = " from ExaminationPaper e where 1=1 " + sqlWhere
				+ " order by e.id desc";
		List<T> list = query(jpql, pageInfo);
		jpql = " select count(*) from ExaminationPaper e where 1=1 " + sqlWhere;
		long maxElements = getTotalElements(jpql);
		Pagination<T> pagination = new Pagination<T>(null, maxElements,
				pageInfo.getPageNo(), pageInfo.getPageSize());
		if (maxElements > 0) {
			pagination.setList(list);
		}
		return pagination;
	}

	@Override
	public Pagination<T> findExaminationPapersByDepartId(String departId,
			PageInfo pageInfo) {
		String jpql = " from ExaminationPaper e where 1=1 and e.department.depart_id='"
				+ departId + "' order by e.id desc";
		List<T> list = query(jpql, pageInfo);
		jpql = " select count(*) from ExaminationPaper e where 1=1  and e.department.depart_id='"
				+ departId + "'";
		long maxElements = getTotalElements(jpql);
		Pagination<T> pagination = new Pagination<T>(null, maxElements,
				pageInfo.getPageNo(), pageInfo.getPageSize());
		if (maxElements > 0) {
			pagination.setList(list);
		}
		return pagination;
	}
}
