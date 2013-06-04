package com.jvwl.examination.action.exampaper;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;
import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.ExaminationPaperDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.exception.BusinessException;
import com.jvwl.examination.model.Department;
import com.jvwl.examination.model.ExaminationPaper;
import com.jvwl.examination.service.IBaseService;
import com.jvwl.examination.service.IExaminationPaperService;
import com.opensymphony.xwork2.ModelDriven;

@Component("examinationPaperListAction")
@SuppressWarnings("serial")
public class ExaminationPaperListAction extends BaseAction implements SessionAware,
		ModelDriven<ExaminationPaperDTO> {

	private IExaminationPaperService<ExaminationPaper> examinationPaperService;
	private IBaseService<Department> baseService;
	private ExaminationPaperDTO examinationPaperDTO = new ExaminationPaperDTO();
	private Pagination<ExaminationPaper> pagination;
	private List<Department> departments;
	private Map<String, Object> sessionMap;
	private Integer pageNo;
	private Integer pageSize;

	public List<Department> getDepartments() {
		return departments;
	}

	public Pagination<ExaminationPaper> getPagination() {
		return pagination;
	}

	@Resource
	public void setBaseService(IBaseService<Department> baseService) {
		this.baseService = baseService;
	}

	@Resource
	public void setExaminationPaperService(IExaminationPaperService<ExaminationPaper> examinationPaperService) {
		this.examinationPaperService = examinationPaperService;
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
		pagination = examinationPaperService.findExaminationPapers(examinationPaperDTO, new PageInfo(
				pageNo, (Integer) sessionMap.get("pageSize")));
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String getDeparts() throws Exception{
		String jpql = "select d.id,d.depart_name from Department d ";
		try {
			departments = baseService.query(jpql, new PageInfo(1, 9999));
		} catch (BusinessException e) {
			e.printStackTrace();
		}	
		return SUCCESS;
	}

	@Override
	@JSON(serialize = false)
	public ExaminationPaperDTO getModel() {
		return examinationPaperDTO;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
