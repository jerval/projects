package com.jvwl.train.action.staff;

import javax.annotation.Resource;

import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.StaffDto;
import com.jvwl.train.dto.ToEmployInfoDto;
import com.jvwl.train.model.Staff;
import com.jvwl.train.service.StaffService;

/**
 * ctt
 * 
 */
@SuppressWarnings("serial")
public class ListStaffAction extends BaseAction {

	private StaffDto dto;
	private Pagination<Staff> pagination;
	private StaffService service;
	private Integer pageNo;
	private Integer pageSize;
	private ToEmployInfoDto toEmployee;

	@Override
	public String execute() throws Exception {
	
		log.info("ListStaffAction:StaffDto:"+dto);
		// 逻辑代码区
		if(pageNo == null){
			pageNo = 1;
		}
		if(pageSize ==null){
			pageSize =20;
		}
		
		pagination = service.findObjects(dto, new PageInfo(pageNo, pageSize));
		return SUCCESS;
	}

	public ToEmployInfoDto getToEmployee() {
		return toEmployee;
	}

	public void setToEmployee(ToEmployInfoDto toEmployee) {
		this.toEmployee = toEmployee;
	}

	public StaffDto getDto() {
		return dto;
	}

	public void setDto(StaffDto dto) {
		this.dto = dto;
	}

	public Pagination<Staff> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Staff> pagination) {
		this.pagination = pagination;
	}

	public StaffService getService() {
		return service;
	}

	@Resource(name = "staffService")
	public void setService(StaffService service) {
		this.service = service;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
