package com.jvwl.train.dto;

import java.util.Date;

import com.jvwl.train.bean.YesNo;

/**
 * 岗位表
 * 
 * @author liuxin
 * 
 */

public class JobDto{
	/**
	 * 岗位ID
	 */
	private String jobId;
	/**
	 * 岗位名称
	 */
	private String jobName;
	/**
	 * 岗位略称
	 */
	private String jobShortName;
	/**
	 * 岗位要求
	 */
	private String describe;
	/**
	 * 登陆者
	 */
	private String insertUser;
	/**
	 * 登陆日期
	 */
	private Date insertDate;
	/**
	 * 更新者
	 */
	private String updateUser;
	/**
	 * 更新日期
	 */
	private Date updateDate;
	/**
	 * 删除标记
	 */
	private YesNo deleteFlag;
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobShortName() {
		return jobShortName;
	}
	public void setJobShortName(String jobShortName) {
		this.jobShortName = jobShortName;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getInsertUser() {
		return insertUser;
	}
	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public YesNo getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(YesNo deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	@Override
	public String toString() {
		return "JobDto [deleteFlag=" + deleteFlag + ", describe=" + describe
				+ ", insertDate=" + insertDate + ", insertUser=" + insertUser
				+ ", jobId=" + jobId + ", jobName=" + jobName
				+ ", jobShortName=" + jobShortName + ", updateDate="
				+ updateDate + ", updateUser=" + updateUser + "]";
	}

	
}
