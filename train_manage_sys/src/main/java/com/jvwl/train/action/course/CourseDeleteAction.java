package com.jvwl.train.action.course;

import javax.annotation.Resource;

import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.service.HrTrainingExecDetailService;

/**
 * 当点击添加时到此Action，通过此Action来完成数据信息的持久化
 * 
 * @author jerval
 */
@SuppressWarnings("serial")
public class CourseDeleteAction extends BaseAction {

	private Integer[] ids;
	private HrTrainingExecDetailService service;

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

	public HrTrainingExecDetailService getService() {
		return service;
	}

	@Resource(name="hrTrainingExecDetailService")
	public void setService(HrTrainingExecDetailService service) {
		this.service = service;
	}

}
