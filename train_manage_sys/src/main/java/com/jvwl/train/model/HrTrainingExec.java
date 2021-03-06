package com.jvwl.train.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jvwl.train.bean.HasOrNot;
import com.jvwl.train.bean.YesNo;
import com.jvwl.train.model.base.BaseBean;

/**
 * 培训实施表
 * 
 * @author wcj
 */
@Entity
public class HrTrainingExec extends BaseBean {
	/**
	 * 培训实施编号
	 */
	@Column(unique = true, length = 9)
	private String trainingexecSeq;
	/**
	 * 培训计划编号
	 */

	private HrTrainingPlan trainingplan;
	/**
	 * 培训名称
	 */
	@Column(length = 60)
	private String courceName;
	/**
	 * 培训目标
	 */
	@Column(length = 1000)
	private String courceAim;
	/**
	 * 教学大纲
	 */
	@Column(length = 1000)
	private String courceOutline;
	/**
	 * 计划课时
	 */
	@Column(precision = 4, scale = 2)
	private Float planHour;
	/**
	 * 培训资料有无
	 */
	@Enumerated(EnumType.ORDINAL)
	private YesNo courcedocFlag;
	/**
	 * 实施管理者
	 */
	@Column(length = 20)
	private String courceManager;
	/**
	 * 结案标志
	 */
	@Enumerated(EnumType.ORDINAL)
	private YesNo okFlag;
	/**
	 * 实际课时
	 */
	@Column(precision = 4, scale = 2)
	private Float execHour;
	/**
	 * 结案综合评价
	 */
	@Column(length = 6)
	private String trainnerImpact;
	/**
	 * 结案报告概要
	 */
	@Column(length = 1000)
	private String trainingReport;
	/**
	 * 结案概要报告资料有无
	 */
	@Enumerated(EnumType.ORDINAL)
	private HasOrNot trainingreportDocFlag;
	/**
	 * 登陆者
	 */
	@Column(length = 20)
	private String insertID;
	/**
	 * 登陆日期
	 */
	private Date insertDate;
	/**
	 * 更新者
	 */
	@Column(length = 20)
	private String updateID;
	/**
	 * 更新日期
	 */
	private Date updateDate;
	/**
	 * 删除标记
	 */
	@Enumerated(EnumType.ORDINAL)
	private YesNo deleteFlag;

	public String getTrainingexecSeq() {
		return trainingexecSeq;
	}

	public void setTrainingexecSeq(String trainingexecSeq) {
		this.trainingexecSeq = trainingexecSeq;
	}

	@ManyToOne
	@JoinColumn(name = "trainingplan_id")
	public HrTrainingPlan getTrainingplan() {
		return trainingplan;
	}

	public void setTrainingplan(HrTrainingPlan trainingplan) {
		this.trainingplan = trainingplan;
	}

	public String getCourceName() {
		return courceName;
	}

	public void setCourceName(String courceName) {
		this.courceName = courceName;
	}

	public String getCourceAim() {
		return courceAim;
	}

	public void setCourceAim(String courceAim) {
		this.courceAim = courceAim;
	}

	public String getCourceOutline() {
		return courceOutline;
	}

	public void setCourceOutline(String courceOutline) {
		this.courceOutline = courceOutline;
	}

	public Float getPlanHour() {
		return planHour;
	}

	public void setPlanHour(Float planHour) {
		this.planHour = planHour;
	}

	public YesNo getCourcedocFlag() {
		return courcedocFlag;
	}

	public void setCourcedocFlag(YesNo courcedocFlag) {
		this.courcedocFlag = courcedocFlag;
	}

	public String getCourceManager() {
		return courceManager;
	}

	public void setCourceManager(String courceManager) {
		this.courceManager = courceManager;
	}

	public YesNo getOkFlag() {
		return okFlag;
	}

	public void setOkFlag(YesNo okFlag) {
		this.okFlag = okFlag;
	}

	public Float getExecHour() {
		return execHour;
	}

	public void setExecHour(Float execHour) {
		this.execHour = execHour;
	}

	public String getTrainnerImpact() {
		return trainnerImpact;
	}

	public void setTrainnerImpact(String trainnerImpact) {
		this.trainnerImpact = trainnerImpact;
	}

	public String getTrainingReport() {
		return trainingReport;
	}

	public void setTrainingReport(String trainingReport) {
		this.trainingReport = trainingReport;
	}

	public HasOrNot getTrainingreportDocFlag() {
		return trainingreportDocFlag;
	}

	public void setTrainingreportDocFlag(HasOrNot trainingreportDocFlag) {
		this.trainingreportDocFlag = trainingreportDocFlag;
	}

	public String getInsertID() {
		return insertID;
	}

	public void setInsertID(String insertID) {
		this.insertID = insertID;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getUpdateID() {
		return updateID;
	}

	public void setUpdateID(String updateID) {
		this.updateID = updateID;
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

}
