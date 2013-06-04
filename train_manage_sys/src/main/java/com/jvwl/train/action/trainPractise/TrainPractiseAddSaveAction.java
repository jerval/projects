package com.jvwl.train.action.trainPractise;


import javax.annotation.Resource;

import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.model.HrTrainingExec;
import com.jvwl.train.service.HrTrainingExecService;
/**
 * 当点击添加时到此Action，通过此Action来完成数据信息的持久化
 * @author lx
 */
@SuppressWarnings("serial")
public class TrainPractiseAddSaveAction extends BaseAction {

	private HrTrainingExec execDetail;
	private HrTrainingExecService service;

	@Override
	public String execute() throws Exception {
		System.out.println(execDetail);
		// 逻辑代码区
		service.save(execDetail);
		return SUCCESS;
	}

	public HrTrainingExecService getService() {
		return service;
	}

	@Resource(name="hrTrainingExecService")
	public void setService(HrTrainingExecService service) {
		this.service = service;
	}

	public HrTrainingExec getExecDetail() {
		return execDetail;
	}

	public void setExecDetail(HrTrainingExec execDetail) {
		this.execDetail = execDetail;
	}

}
