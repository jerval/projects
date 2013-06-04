package com.jvwl.train.action.course;

import javax.annotation.Resource;
import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.model.HrTrainingExecDetail;
import com.jvwl.train.service.HrTrainingExecDetailService;

/**
 * 当点击修改时到此Action，通过此Action来获取要修改的对象的数据信息
 * 
 * @author jerval
 */
@SuppressWarnings("serial")
public class CourseUpdateAction extends BaseAction {

	private HrTrainingExecDetail execDetail;
	private HrTrainingExecDetailService service;

	@Override
	public String execute() throws Exception {
		log.info("CourseUpdateAction:HrTrainingExecDetail:"+execDetail);
		// 逻辑代码区
		execDetail = service.findById(execDetail.getId());
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
