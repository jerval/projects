package com.jvwl.train.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.jvwl.train.bean.InterviewResult;
import com.jvwl.train.model.base.BaseBean;

/**
 * 应聘人员面试履历表
 * 
 * @author liuxin
 * 
 */
@Entity
public class ToEmployTestInfo extends BaseBean {
	/**
	 * 应聘人员编号
	 */
	
	private ToEmployInfo employ;

	/**
	 * 面试次数
	 */
	private int interviewSubNo;

	/**
	 * 约定面试时间
	 */
	private Date interviewPlanTime;

	/**
	 * 约定面试人
	 */
	
	private String interviewPlanPeople;

	/**
	 * 实际面试时间
	 */
	private Date interviewTime;

	/**
	 * 实际面试人
	 */
	
	private String interviewPeople;

	/**
	 * 面试综合评价
	 */
	
	private String interviewRecord;

	/**
	 * 后续措施
	 */
	
	private String inteviewNext;

	/**
	 * 面试结论
	 */
	
	private InterviewResult interviewResult;

	/**
	 * 登陆者
	 */
	
	private String insertUser;

	/**
	 * 登陆日
	 */
	private Date insertDate;

	/**
	 * 最后更新者
	 */
	
	private String updateUser;

	/**
	 * 最后更新日
	 */
	private Date updateDate;
	
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "toEmploy_id")
	public ToEmployInfo getEmploy() {
		return employ;
	}

	public void setEmploy(ToEmployInfo employ) {
		this.employ = employ;
	}

	public int getInterviewSubNo() {
		return interviewSubNo;
	}

	public void setInterviewSubNo(int interviewSubNo) {
		this.interviewSubNo = interviewSubNo;
	}

	public Date getInterviewPlanTime() {
		return interviewPlanTime;
	}

	public void setInterviewPlanTime(Date interviewPlanTime) {
		this.interviewPlanTime = interviewPlanTime;
	}
	@Column(length = 20)
	public String getInterviewPlanPeople() {
		return interviewPlanPeople;
	}

	public void setInterviewPlanPeople(String interviewPlanPeople) {
		this.interviewPlanPeople = interviewPlanPeople;
	}

	public Date getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(Date interviewTime) {
		this.interviewTime = interviewTime;
	}
	@Column(length = 20)
	public String getInterviewPeople() {
		return interviewPeople;
	}

	public void setInterviewPeople(String interviewPeople) {
		this.interviewPeople = interviewPeople;
	}
	@Lob
	@Basic(fetch = FetchType.LAZY)
	public String getInterviewRecord() {
		return interviewRecord;
	}

	public void setInterviewRecord(String interviewRecord) {
		this.interviewRecord = interviewRecord;
	}
	@Column(length = 200)
	public String getInteviewNext() {
		return inteviewNext;
	}

	public void setInteviewNext(String inteviewNext) {
		this.inteviewNext = inteviewNext;
	}
	@Enumerated(EnumType.ORDINAL)
	public InterviewResult getInterviewResult() {
		return interviewResult;
	}

	public void setInterviewResult(InterviewResult interviewResult) {
		this.interviewResult = interviewResult;
	}
	@Column(length = 20, nullable = false)
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
	@Column(length = 20, nullable = false)
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

}
