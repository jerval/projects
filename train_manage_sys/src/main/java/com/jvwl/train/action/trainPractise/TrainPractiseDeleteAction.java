package com.jvwl.train.action.trainPractise;

import javax.annotation.Resource;

import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.service.HrTrainingExecService;

/**
 * 当点击添加时到此Action，通过此Action来完成数据信息的持久化
 * 
 * @author jerval
 */
@SuppressWarnings("serial")
public class TrainPractiseDeleteAction extends BaseAction {

	private Integer[] ids;
	private HrTrainingExecService service;

	@Override
	public String execute() throws Exception {
		log.info("CourseDeleteAction:ids.length:"+ids.length);
		// 逻辑代码区
		service.delete(ids);
		return SUCCESS;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public HrTrainingExecService getService() {
		return service;
	}

	@Resource(name="hrTrainingExecDetailService")
	public void setService(HrTrainingExecService service) {
		this.service = service;
	}

}
