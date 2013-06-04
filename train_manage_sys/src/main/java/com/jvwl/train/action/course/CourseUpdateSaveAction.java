package com.jvwl.train.action.course;

import javax.annotation.Resource;

import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.model.HrTrainingExecDetail;
import com.jvwl.train.service.HrTrainingExecDetailService;

/**
 * 当点击修改中的保存时到此Action，通过此Action来完成修改后的数据的持久化
 * 
 * @author jerval
 */
@SuppressWarnings("serial")
public class CourseUpdateSaveAction extends BaseAction {

	private HrTrainingExecDetail execDetail;
	private HrTrainingExecDetailService service;

	@Override
	public String execute() throws Exception {
		log.info("CourseUpdateSaveAction:execDetail:"+execDetail);
		// 逻辑代码区
		service.update(execDetail);
		return SUCCESS;
	}

	public HrTrainingExecDetail getExecDetail() {
		return execDetail;
	}

	public void setExecDetail(HrTrainingExecDetail execDetail) {
		this.execDetail = execDetail;
	}

	public HrTrainingExecDetailService getService() {
		return service;
	}
	@Resource(name="hrTrainingExecDetailService")
	public void setService(HrTrainingExecDetailService service) {
		this.service = service;
	}

}
