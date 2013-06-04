package com.jvwl.train.action.trainPractise;

import javax.annotation.Resource;

import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.model.HrTrainingExec;
import com.jvwl.train.service.HrTrainingExecService;

/**
 * 当点击修改中的保存时到此Action，通过此Action来完成修改后的数据的持久化
 * 
 * @author jerval
 */
@SuppressWarnings("serial")
public class TrainPractiseUpdateSaveAction extends BaseAction {

	private HrTrainingExec exec;
	private HrTrainingExecService service;

	@Override
	public String execute() throws Exception {
		log.info("CourseUpdateSaveAction:execDetail:"+exec);
		// 逻辑代码区
		service.update(exec);
		return SUCCESS;
	}

	public HrTrainingExec getExecDetail() {
		return exec;
	}

	public void setExecDetail(HrTrainingExec exec) {
		this.exec = exec;
	}

	public HrTrainingExecService getService() {
		return service;
	}
	@Resource(name="hrTrainingExecService")
	public void setService(HrTrainingExecService service) {
		this.service = service;
	}

}
