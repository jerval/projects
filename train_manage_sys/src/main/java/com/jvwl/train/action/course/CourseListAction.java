package com.jvwl.train.action.course;

import javax.annotation.Resource;

import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.HrTrainingExecDetailDto;
import com.jvwl.train.model.HrTrainingExecDetail;
import com.jvwl.train.service.HrTrainingExecDetailService;

/**
 * 列表Action，通过页面传入的pageNo,pageSize以及查询条件的封装类dto去数据库查询数据
 * 最后将查询到的数据以及数据的条数等信息放入pagination中
 * 
 * @author jerval
 */
@SuppressWarnings("serial")
public class CourseListAction extends BaseAction {

	private HrTrainingExecDetailDto dto ;
	private Pagination<HrTrainingExecDetail> pagination;
	private HrTrainingExecDetailService service;
	private Integer pageNo;
	private Integer pageSize;

	@Override
	public String execute() throws Exception {
		log.info("CourseListAction:HrTrainingExecDetailDto:"+dto);
		// 逻辑代码区
		if(pageNo == null){
			pageNo = 1;
		}
		if(pageSize ==null){
			pageSize =5;
		}
		pagination = service.findObjects(dto, new PageInfo(pageNo, pageSize));
		return SUCCESS;
	}

	public Pagination<HrTrainingExecDetail> getPagination() {
		return pagination;
	}

	public HrTrainingExecDetailService getService() {
		return service;
	}

	@Resource(name = "hrTrainingExecDetailService")
	public void setService(HrTrainingExecDetailService service) {
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

	public void setPagination(Pagination<HrTrainingExecDetail> pagination) {
		this.pagination = pagination;
	}

	public void setDto(HrTrainingExecDetailDto dto) {
		this.dto = dto;
	}

	public HrTrainingExecDetailDto getDto() {
		return dto;
	}

}
