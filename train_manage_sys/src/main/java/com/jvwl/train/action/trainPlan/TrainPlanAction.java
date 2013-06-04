package com.jvwl.train.action.trainPlan;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.jvwl.train.action.base.BaseAction;
import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.HrTrainingPlanDto;
import com.jvwl.train.model.HrTrainingPlan;
import com.jvwl.train.service.HrTrainingPlanService;

@SuppressWarnings("serial")
public class TrainPlanAction extends BaseAction {
	private HrTrainingPlanService service;
	private HrTrainingPlanDto trainPlandto;
	private HrTrainingPlan trainPlan;
	private Pagination<HrTrainingPlan> pagination;
	private Integer pageNo;
	private Integer pageSize;
	private int delete_nos[];

	public HrTrainingPlanDto getTrainPlandto() {
		return trainPlandto;
	}

	public void setTrainPlandto(HrTrainingPlanDto trainPlandto) {
		this.trainPlandto = trainPlandto;
	}

	public HrTrainingPlan getTrainPlan() {
		return trainPlan;
	}

	public void setTrainPlan(HrTrainingPlan trainPlan) {
		this.trainPlan = trainPlan;
	}

	public Pagination<HrTrainingPlan> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<HrTrainingPlan> pagination) {
		this.pagination = pagination;
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

	public int[] getDelete_nos() {
		return delete_nos;
	}

	public void setDelete_nos(int[] deleteNos) {
		delete_nos = deleteNos;
	}

	public String list() {
		if(pageNo == null){
			pageNo = 1;
		}
		if(pageSize ==null){
			pageSize =2;
		}
		pagination = service.findObjects(trainPlandto, new PageInfo(pageNo, pageSize));
		List<HrTrainingPlanDto> list = new ArrayList<HrTrainingPlanDto>();
		return "list";
	}

	public String toUpdate() {
		trainPlan = service.findById(trainPlan.getId());
		return "toUpdate";
	}

	public String update() {
		service.update(trainPlan);
		return "update";
	}

	public String add() {
		service.save(trainPlan);
		return "add";
	}

	public HrTrainingPlanService getService() {
		return service;
	}

	@Resource(name = "hrTrainingPlanService")
	public void setService(HrTrainingPlanService service) {
		this.service = service;
	}

}
