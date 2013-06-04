package com.jvwl.train.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jvwl.train.model.base.BaseBean;

/**
 * 部门(项目)表
 * 
 * @author liuxin
 * 
 */
@Entity
public class Department extends BaseBean {
	/**
	 * 部门编号
	 */
	private String departmentId;
	/**
	 * 部门名称
	 */
	private String departmentName;
	/**
	 * 部门略称
	 */
	private String deptShortName;
	/**
	 * 部门管理者
	 */
	private String manager;
	/**
	 * 辅助管理者1
	 */
	private String managerAssist1;
	/**
	 * 辅助管理者2
	 */
	private String managerAssist2;
	/**
	 * 上级部门
	 */
	private Department parentDepartment;
	/**
	 * 部门类型
	 */
	private String departmentType;
	/**
	 * 部门性质
	 */
	private String deptProperty;
	/**
	 * 部门计划设立日期
	 */
	private Date planBeginDate;
	/**
	 * 部门计划终止日期
	 */
	private Date planEndDate;
	/**
	 * 部门设立日期
	 */
	private Date beginDate;
	/**
	 * 部门终止日期
	 */
	private Date endDate;
	/**
	 * 详细说明
	 */
	private String detailNotes;
	/**
	 * CMMI编号
	 */
	private String cmmi3Id;
	/**
	 * CMMI全称
	 */
	private String cmmi3Name;
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

	@Column(unique = true, length = 20)
	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	@ManyToOne
	@JoinColumn(name = "parentDepartment_id")
	public Department getParentDepartment() {
		return parentDepartment;
	}

	public void setParentDepartment(Department parentDepartment) {
		this.parentDepartment = parentDepartment;
	}

	@Column( length = 100)
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Column(length = 40)
	public String getDeptShortName() {
		return deptShortName;
	}

	public void setDeptShortName(String deptShortName) {
		this.deptShortName = deptShortName;
	}

	@Column(length = 20)
	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Column(length = 20)
	public String getManagerAssist1() {
		return managerAssist1;
	}

	public void setManagerAssist1(String managerAssist1) {
		this.managerAssist1 = managerAssist1;
	}

	@Column(length = 20)
	public String getManagerAssist2() {
		return managerAssist2;
	}

	public void setManagerAssist2(String managerAssist2) {
		this.managerAssist2 = managerAssist2;
	}

	@Column(length = 20)
	public String getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}

	@Column(length = 20)
	public String getDeptProperty() {
		return deptProperty;
	}

	public void setDeptProperty(String deptProperty) {
		this.deptProperty = deptProperty;
	}

	@Temporal(TemporalType.DATE)
	public Date getPlanBeginDate() {
		return planBeginDate;
	}

	public void setPlanBeginDate(Date planBeginDate) {
		this.planBeginDate = planBeginDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	public String getDetailNotes() {
		return detailNotes;
	}

	public void setDetailNotes(String detailNotes) {
		this.detailNotes = detailNotes;
	}

	@Column(length = 40)
	public String getCmmi3Id() {
		return cmmi3Id;
	}

	public void setCmmi3Id(String cmmi3Id) {
		this.cmmi3Id = cmmi3Id;
	}

	@Column(length = 100)
	public String getCmmi3Name() {
		return cmmi3Name;
	}

	public void setCmmi3Name(String cmmi3Name) {
		this.cmmi3Name = cmmi3Name;
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

}
