package com.jvwl.train.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jvwl.train.bean.YesNo;
import com.jvwl.train.model.base.BaseBean;

/**
 * 培训计划表
 * 
 * @author wangchan
 */
@Entity
public class HrTrainingPlan  extends BaseBean{
	/**
	 * 培训计划编号
	 */
	
	private String trainingplanSeq;
	/**
	 * 计划名称
	 */
	
	private String planName;
	/**
	 * 计划目标
	 */
	
	private String planAim;
	/**
	 * 计划制定人
	 */
	
	private Staff staff;
	/**
	 * 计划制定日期
	 */
	
	private Date planDate;
	/**
	 * 计划课时
	 */
	
	private Float trainingHour;
	/**
	 * 计划开始日期
	 */
	
	private Date planstartDate;
	/**
	 * 计划完成日期
	 */
	
	private Date planendDate;
	/**
	 * 培训类型
	 */
	
	private String trainingType;
	/**
	 * 实施标志
	 */
	
	private String planexecFlag;
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
	/**
	 * 删除标志
	 */
	
	private YesNo deleteFlag;

	@Column(unique = true, length = 9)
	public String getTrainingplanSeq() {
		return trainingplanSeq;
	}

	public void setTrainingplanSeq(String trainingplanSeq) {
		this.trainingplanSeq = trainingplanSeq;
	}

	@Column(unique = true, length = 60)
	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	@Column(length = 100)
	public String getPlanAim() {
		return planAim;
	}

	public void setPlanAim(String planAim) {
		this.planAim = planAim;
	}

	@ManyToOne
	@JoinColumn(name = "planUser")
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Temporal(TemporalType.DATE)
	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	@Column(precision = 4, scale = 1)
	public Float getTrainingHour() {
		return trainingHour;
	}

	public void setTrainingHour(Float trainingHour) {
		this.trainingHour = trainingHour;
	}

	@Temporal(TemporalType.DATE)
	public Date getPlanstartDate() {
		return planstartDate;
	}

	public void setPlanstartDate(Date planstartDate) {
		this.planstartDate = planstartDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getPlanendDate() {
		return planendDate;
	}

	public void setPlanendDate(Date planendDate) {
		this.planendDate = planendDate;
	}

	@Column(length = 30)
	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}

	@Column(length = 30)
	public String getPlanexecFlag() {
		return planexecFlag;
	}

	public void setPlanexecFlag(String planexecFlag) {
		this.planexecFlag = planexecFlag;
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
