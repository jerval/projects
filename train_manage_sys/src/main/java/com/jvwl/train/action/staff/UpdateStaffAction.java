package com.jvwl.train.action.staff;

import javax.annotation.Resource;

import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.model.Staff;
import com.jvwl.train.service.StaffService;

/**
 * 
 * ctt
 */
@SuppressWarnings("serial")
public class UpdateStaffAction extends BaseAction {

	private Staff staff;
	private StaffService service;

	@Override
	public String execute() throws Exception {
		log.info("UpdateStaffAction:staff:"+staff);
		// 逻辑代码区
		service.update(staff);
		return SUCCESS;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public StaffService getService() {
		return service;
	}

	@Resource(name = "staffService")
	public void setService(StaffService service) {
		this.service = service;
	}

}
