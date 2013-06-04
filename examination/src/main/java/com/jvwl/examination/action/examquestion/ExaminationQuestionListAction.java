package com.jvwl.examination.action.examquestion;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.ExaminationQuestionDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.exception.BusinessException;
import com.jvwl.examination.model.ExaminationPaper;
import com.jvwl.examination.model.ExaminationQuestion;
import com.jvwl.examination.service.IBaseService;
import com.jvwl.examination.service.IExaminationQuestionService;
import com.opensymphony.xwork2.ModelDriven;

@Component("examinationQuestionListAction")
@SuppressWarnings("serial")
public class ExaminationQuestionListAction extends BaseAction implements SessionAware,
		ModelDriven<ExaminationQuestionDTO> {

	private IExaminationQuestionService<ExaminationQuestion> examinationQuestionService;
	private IBaseService<ExaminationPaper> baseService;
	private ExaminationQuestionDTO examinationQuestionDTO = new ExaminationQuestionDTO();
	private Pagination<ExaminationQuestion> pagination;
	private List<ExaminationPaper> examinationPapers;
	private Map<String, Object> sessionMap;
	private Integer pageNo;
	private Integer pageSize;

	public List<ExaminationPaper> getExaminationPapers() {
		return examinationPapers;
	}

	public Pagination<ExaminationQuestion> getPagination() {
		return pagination;
	}

	@Resource
	public void setBaseService(IBaseService<ExaminationPaper> baseService) {
		this.baseService = baseService;
	}

	@Resource
	public void setExaminationQuestionService(IExaminationQuestionService<ExaminationQuestion> examinationQuestionService) {
		this.examinationQuestionService = examinationQuestionService;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	@JSON(serialize = false)
	public String execute() throws Exception {
		if (pageNo == null) {
			pageNo = 1;
		}
		if (sessionMap.get("pageSize") == null) {
			sessionMap.put("pageSize", 10);
		} else if (pageSize != null) {
			sessionMap.put("pageSize", pageSize);
		}
		pagination = examinationQuestionService.findExaminationQuestions(examinationQuestionDTO, new PageInfo(
				pageNo, (Integer) sessionMap.get("pageSize")));
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getExamPapers() throws Exception{
		String jpql = "select e.id,e.paper_name from ExaminationPaper e ";
		try {
			examinationPapers = baseService.query(jpql, new PageInfo(1, 9999));
		} catch (BusinessException e) {
			e.printStackTrace();
		}	
		return SUCCESS;
	}

	@Override
	@JSON(serialize = false)
	public ExaminationQuestionDTO getModel() {
		return examinationQuestionDTO;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
