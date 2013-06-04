package com.jvwl.examination.action.front;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.ExaminationScoreDTO;
import com.jvwl.examination.dto.OperateEmployee;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.ExaminationScore;
import com.jvwl.examination.service.IExaminationScoreService;

@Component("myScoreAction")
@SuppressWarnings("serial")
public class MyScoreAction extends BaseAction implements SessionAware {

	private IExaminationScoreService<ExaminationScore> scoreService;
	private Pagination<ExaminationScore> pagination;
	private Map<String, Object> sessionMap;
	private Integer pageNo;
	private Integer pageSize;

	@Resource(name = "examinationScoreService")
	public void setScoreService(
			IExaminationScoreService<ExaminationScore> scoreService) {
		this.scoreService = scoreService;
	}

	public Pagination<ExaminationScore> getPagination() {
		return pagination;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@JSON(serialize = false)
	public String toMyScore() {
		return "toMyScore";
	}
	
	@Override
	@JSON(serialize = false)
	public String execute() throws Exception {
		OperateEmployee operateEmployee = (OperateEmployee) sessionMap
				.get("operateEmployee");
		if (operateEmployee != null) {
			ExaminationScoreDTO eDto = new ExaminationScoreDTO();
			eDto.setEmployee_id(operateEmployee.getEmp_id());
			if (pageNo == null || "".equals(pageNo)) {
				pageNo = 1;
			}
			if (sessionMap.get("pageSize") == null) {
				sessionMap.put("pageSize", 10);
			} else if (pageSize != null) {
				sessionMap.put("pageSize", pageSize);
			}
			pagination = scoreService.findExaminationScores(eDto, new PageInfo(
					pageNo, (Integer) sessionMap.get("pageSize")));

		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
