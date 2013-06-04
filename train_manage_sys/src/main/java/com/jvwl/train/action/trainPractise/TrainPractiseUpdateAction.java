package com.jvwl.train.action.trainPractise;

import javax.annotation.Resource;

import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.model.HrTrainingExec;
import com.jvwl.train.service.HrTrainingExecService;

/**
 * 当点击修改时到此Action，通过此Action来获取要修改的对象的数据信息
 * 
 * @author jerval
 */
@SuppressWarnings("serial")
public class TrainPractiseUpdateAction extends BaseAction {

	private HrTrainingExec exec;
	private HrTrainingExecService service;

	@Override
	public String execute() throws Exception {
		System.out.println(exec);
		// 逻辑代码区
		return SUCCESS;
	}

	public HrTrainingExec getExec() {
		return exec;
	}

	public void setExec(HrTrainingExec exec) {
		this.exec = exec;
	}

	public HrTrainingExecService getService() {
		return service;
	}

	@Resource(name = "hrTrainingExecService")
	public void setService(HrTrainingExecService service) {
		this.service = service;
	}

}
