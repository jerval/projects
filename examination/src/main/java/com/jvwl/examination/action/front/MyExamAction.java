package com.jvwl.examination.action.front;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.OperateEmployee;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.ExaminationPaper;
import com.jvwl.examination.service.IExaminationPaperService;

@SuppressWarnings("serial")
@Component("myExamAction")
public class MyExamAction extends BaseAction implements SessionAware {
	private Date startTime;
	private Map<String, Object> sessionMap;
	private IExaminationPaperService<ExaminationPaper> examPaperService;
	private ExaminationPaper examPaper;
	private Pagination<ExaminationPaper> pagination;
	private Integer pageNo;
	private Integer pageSize;

	public void setExamPaper(ExaminationPaper examPaper) {
		this.examPaper = examPaper;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public ExaminationPaper getExamPaper() {
		return examPaper;
	}

	public Pagination<ExaminationPaper> getPagination() {
		return pagination;
	}

	@Resource(name = "examinationPaperService")
	public void setExamPaperService(
			IExaminationPaperService<ExaminationPaper> examPaperService) {
		this.examPaperService = examPaperService;
	}

	@JSON(serialize = false)
	public String toExam() {
		startTime = new Date();
		sessionMap.put("startTime", startTime);
		return "toExam";
	}
	
	@JSON(serialize = false)
	public String examInfo() {
		examPaper = examPaperService.findByPaperId((String) sessionMap
				.get("paper_id"));
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String toWelcome() {
		examPaper = examPaperService.findByPaperId(examPaper.getPaper_id());
		sessionMap.put("paper_id", examPaper.getPaper_id());
		return "toWelcome";
	}

	@JSON(serialize = false)
	public String toSelectPaper() {
		return "toSelectPaper";
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
		OperateEmployee operateEmployee = (OperateEmployee) sessionMap
				.get("operateEmployee");
		pagination = examPaperService.findExaminationPapersByDepartId(
				operateEmployee.getDepartment().getDepart_id(), new PageInfo(
						pageNo, (Integer) sessionMap.get("pageSize")));
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
