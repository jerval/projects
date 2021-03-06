package com.jvwl.train.action.staff;

import javax.annotation.Resource;

import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.service.StaffService;


/**
 * 当点击添加时到此Action，通过此Action来完成数据信息的持久化
 * 
 * @author jerval
 */
@SuppressWarnings("serial")
public class DeleteStaffAction extends BaseAction {

	private Integer[] ids;
	private StaffService service;

	@Override
	public String execute() throws Exception {
		log.info("DeleteStaffAction:ids.length:"+ids.length);
		// 逻辑代码区
		service.delete(ids);
		return SUCCESS;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public StaffService getService() {
		return service;
	}

	@Resource(name = "staffService")
	public void setService(StaffService service) {
		this.service = service;
	}
}
