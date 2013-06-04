package com.jvwl.examination.action.examkey;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;
import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.ExaminationKeyDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.exception.BusinessException;
import com.jvwl.examination.model.ExaminationQuestion;
import com.jvwl.examination.model.ExaminationKey;
import com.jvwl.examination.service.IBaseService;
import com.jvwl.examination.service.IExaminationKeyService;
import com.opensymphony.xwork2.ModelDriven;

@Component("examinationKeyListAction")
@SuppressWarnings("serial")
public class ExaminationKeyListAction extends BaseAction implements SessionAware,
		ModelDriven<ExaminationKeyDTO> {

	private IExaminationKeyService<ExaminationKey> examinationKeyService;
	private IBaseService<ExaminationQuestion> baseService;
	private ExaminationKeyDTO examinationKeyDTO = new ExaminationKeyDTO();
	private Pagination<ExaminationKey> pagination;
	private List<ExaminationQuestion> examinationQuestions;
	private Map<String, Object> sessionMap;
	private Integer pageNo;
	private Integer pageSize;

	public List<ExaminationQuestion> getExaminationQuestions() {
		return examinationQuestions;
	}

	public Pagination<ExaminationKey> getPagination() {
		return pagination;
	}

	@Resource
	public void setBaseService(IBaseService<ExaminationQuestion> baseService) {
		this.baseService = baseService;
	}

	@Resource
	public void setExaminationKeyService(IExaminationKeyService<ExaminationKey> examinationKeyService) {
		this.examinationKeyService = examinationKeyService;
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
		pagination = examinationKeyService.findExaminationKeys(examinationKeyDTO, new PageInfo(
				pageNo, (Integer) sessionMap.get("pageSize")));
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getExamQuestions() throws Exception{
		String jpql = "select e.id,e.question_id from ExaminationQuestion e ";
		try {
			examinationQuestions = baseService.query(jpql, new PageInfo(1, 9999));
		} catch (BusinessException e) {
			e.printStackTrace();
		}	
		return SUCCESS;
	}

	@Override
	@JSON(serialize = false)
	public ExaminationKeyDTO getModel() {
		return examinationKeyDTO;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
