package com.jvwl.train.dto;



public class HrTrainingPlanDto {
	
	/**
	 * 培训计划编号
	 */
	
	private String trainingplanSeq;
	/**
	 * 计划名称
	 */
	
	private String planName;
	
	/**
	 * 计划制定人
	 */
	
	private String userChinaname;
	
	/**
	 * 培训类型
	 */
	
	private String trainingType;
	/**
	 * 实施标志
	 */
	
	private String planexecFlag;
	
	
	
	public String getTrainingplanSeq() {
		return trainingplanSeq;
	}



	public void setTrainingplanSeq(String trainingplanSeq) {
		this.trainingplanSeq = trainingplanSeq;
	}



	public String getPlanName() {
		return planName;
	}



	public void setPlanName(String planName) {
		this.planName = planName;
	}



	public String getUserChinaname() {
		return userChinaname;
	}



	public void setUserChinaname(String userChinaname) {
		this.userChinaname = userChinaname;
	}



	public String getTrainingType() {
		return trainingType;
	}



	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}



	public String getPlanexecFlag() {
		return planexecFlag;
	}



	public void setPlanexecFlag(String planexecFlag) {
		this.planexecFlag = planexecFlag;
	}



	@Override
	public String toString() {
		return "HrTrainingPlanDto [planName=" + planName + ", planexecFlag="
				+ planexecFlag + ", trainingType=" + trainingType
				+ ", trainingplanSeq=" + trainingplanSeq + ", userChinaname="
				+ userChinaname + "]";
	}

    
}
