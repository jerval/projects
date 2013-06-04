package com.jvwl.train.action.feedback;

import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.model.HrTrainingExecDetail;
import com.jvwl.train.model.HrTrainingExecUserFeedback;
import com.jvwl.train.service.HrTrainingExecDetailService;
@SuppressWarnings("serial")
public class ListFeedbackAction extends BaseAction {
	
	private HrTrainingExecUserFeedback feedback ;
	public HrTrainingExecUserFeedback getFeedback() {
		return feedback;
	}

	public void setFeedback(HrTrainingExecUserFeedback feedback) {
		this.feedback = feedback;
	}


	private Pagination<HrTrainingExecDetail> pagination;
	private HrTrainingExecDetailService service;
	private Integer pageNo;
	private Integer pageSize;
	

	public Pagination<HrTrainingExecDetail> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<HrTrainingExecDetail> pagination) {
		this.pagination = pagination;
	}

	public HrTrainingExecDetailService getService() {
		return service;
	}

	public void setService(HrTrainingExecDetailService service) {
		this.service = service;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	
	@Override
	public String execute() throws Exception {
		System.out.println(feedback);
		//逻辑代码区
		
		return SUCCESS;
	}

}
