package com.jvwl.train.action.feedback;

import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.model.HrTrainingExecUserFeedback;
import com.jvwl.train.service.HrTrainingExecUserFeedbackService;
/**
 * 
 * @author lhw
 *
 */
@SuppressWarnings("serial")
public class DetailFeedbackAction extends BaseAction {
	
	private HrTrainingExecUserFeedback feedback ;
	
	public HrTrainingExecUserFeedback getFeedback() {
		return feedback;
	}
	public void setFeedback(HrTrainingExecUserFeedback feedback) {
		this.feedback = feedback;
	}

	private Pagination<HrTrainingExecUserFeedback> pagination;
	private HrTrainingExecUserFeedbackService service;
	
	public Pagination<HrTrainingExecUserFeedback> getPagination() {
		return pagination;
	}
	public void setPagination(Pagination<HrTrainingExecUserFeedback> pagination) {
		this.pagination = pagination;
	}
	public HrTrainingExecUserFeedbackService getService() {
		return service;
	}
	public void setService(HrTrainingExecUserFeedbackService service) {
		this.service = service;
	}
	
	@Override
	public String execute() throws Exception{
		System.out.println(feedback);
		
		return SUCCESS;
	}

}
