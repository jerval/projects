package com.jvwl.train.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.jvwl.train.bean.YesNo;
import com.jvwl.train.model.base.BaseBean;

/**
 * 岗位表
 * 
 * @author liuxin
 * 
 */
@Entity
public class Job extends BaseBean {
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
	private String memo;
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

	@Column(unique = true, length = 6)
	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	@Column(length = 100)
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Column(length = 40)
	public String getJobShortName() {
		return jobShortName;
	}

	public void setJobShortName(String jobShortName) {
		this.jobShortName = jobShortName;
	}

	@Column(length = 100)
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(length = 20)
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

	@Column(length = 20)
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

	@Enumerated(EnumType.ORDINAL)
	public YesNo getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(YesNo deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
