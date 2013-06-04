package com.jvwl.train.action.course;

import javax.annotation.Resource;

import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.model.HrTrainingExecDetail;
import com.jvwl.train.service.HrTrainingExecDetailService;

/**
 * 当点击添加时到此Action，通过此Action来完成数据信息的持久化
 * 
 * @author jerval
 */
@SuppressWarnings("serial")
public class CourseAddSaveAction extends BaseAction {

	private HrTrainingExecDetail execDetail;
	private HrTrainingExecDetailService service;

	@Override
	public String execute() throws Exception {
		log.info("CourseAddSaveAction:execDetail:"+execDetail);
		// 逻辑代码区
		service.save(execDetail);
		return SUCCESS;
	}

	public HrTrainingExecDetailService getService() {
		return service;
	}

	@Resource(name="hrTrainingExecDetailService")
	public void setService(HrTrainingExecDetailService service) {
		this.service = service;
	}

	public HrTrainingExecDetail getExecDetail() {
		return execDetail;
	}

	public void setExecDetail(HrTrainingExecDetail execDetail) {
		this.execDetail = execDetail;
	}
}
