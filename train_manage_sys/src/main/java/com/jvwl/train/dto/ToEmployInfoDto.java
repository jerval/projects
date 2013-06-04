package com.jvwl.train.dto;

import java.util.Date;

import com.jvwl.train.bean.EmployState;
import com.jvwl.train.bean.InterviewResult;

/**
 * 应聘人员信息表
 * 
 * @author ctt
 * 
 */

public class ToEmployInfoDto {
	/**
	 * 岗位ID
	 */
	private String jobId;
	/**
	 * 应聘人员状态
	 */
	private EmployState type;
	/**
	 * 应聘者姓名
	 */
	private String userChinaName;
	/**
	 * 前工作单位
	 */
	private String preWorkComp;
	/**
	 * 面试结果
	 */
	private InterviewResult interViewResult;
	/**
	 * 毕业院校
	 */
	
	private String schoolName;
	/**
	 * 应聘日期
	 */
	private Date comeDate;
	private Date comeDate2;
	
	public Date getComeDate2() {
		return comeDate2;
	}
	public void setComeDate2(Date comeDate2) {
		this.comeDate2 = comeDate2;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public EmployState getType() {
		return type;
	}
	public void setType(EmployState type) {
		this.type = type;
	}
	public String getUserChinaName() {
		return userChinaName;
	}
	public void setUserChinaName(String userChinaName) {
		this.userChinaName = userChinaName;
	}
	public String getPreWorkComp() {
		return preWorkComp;
	}
	public void setPreWorkComp(String preWorkComp) {
		this.preWorkComp = preWorkComp;
	}
	public InterviewResult getInterViewResult() {
		return interViewResult;
	}
	public void setInterViewResult(InterviewResult interViewResult) {
		this.interViewResult = interViewResult;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Date getComeDate() {
		return comeDate;
	}
	public void setComeDate(Date comeDate) {
		this.comeDate = comeDate;
	}
	@Override
	public String toString() {
		return "ToEmployInfoDto [comeDate=" + comeDate + ", comeDate2="
				+ comeDate2 + ", interViewResult=" + interViewResult
				+ ", jobId=" + jobId + ", preWorkComp=" + preWorkComp
				+ ", schoolName=" + schoolName + ", type=" + type
				+ ", userChinaName=" + userChinaName + "]";
	}
	
}
