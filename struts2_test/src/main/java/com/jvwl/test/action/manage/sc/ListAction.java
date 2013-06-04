package com.jvwl.test.action.manage.sc;

import com.jvwl.test.action.BaseAction;
import com.jvwl.test.dto.PageInfo;
import com.jvwl.test.dto.Pagination;
import com.jvwl.test.model.Sc;
import com.jvwl.test.service.ScService;

@SuppressWarnings("serial")
public class ListAction extends BaseAction {

	private Pagination<Sc> pagination;
	private ScService scService = new ScService();
	private Integer pageNo;
	private Integer pageSize;

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Pagination<Sc> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Sc> pagination) {
		this.pagination = pagination;
	}

	@Override
	public String execute() throws Exception {
		if(pageNo==null){
			pageNo = 1;
		}if(pageSize==null){
			pageSize=200;
		}
		pagination = scService.findScs(null, new PageInfo(pageNo, pageSize));
		return SUCCESS;
	}

}
