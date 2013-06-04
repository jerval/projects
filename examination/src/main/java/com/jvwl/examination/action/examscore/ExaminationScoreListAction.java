package com.jvwl.examination.action.examscore;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.ExaminationScoreDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.ExaminationScore;
import com.jvwl.examination.service.IExaminationScoreService;
import com.opensymphony.xwork2.ModelDriven;

@Component("examinationScoreListAction")
@SuppressWarnings("serial")
public class ExaminationScoreListAction extends BaseAction implements SessionAware,
		ModelDriven<ExaminationScoreDTO> {

	private IExaminationScoreService<ExaminationScore> examinationScoreService;
	private ExaminationScoreDTO examinationScoreDTO = new ExaminationScoreDTO();
	private Pagination<ExaminationScore> pagination;
	private Map<String, Object> sessionMap;
	private Integer pageNo;
	private Integer pageSize;

	public Pagination<ExaminationScore> getPagination() {
		return pagination;
	}

	@Resource
	public void setExaminationScoreService(IExaminationScoreService<ExaminationScore> examinationScoreService) {
		this.examinationScoreService = examinationScoreService;
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
		pagination = examinationScoreService.findExaminationScores(examinationScoreDTO, new PageInfo(
				pageNo, (Integer) sessionMap.get("pageSize")));
		return SUCCESS;
	}

	@Override
	@JSON(serialize = false)
	public ExaminationScoreDTO getModel() {
		return examinationScoreDTO;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
