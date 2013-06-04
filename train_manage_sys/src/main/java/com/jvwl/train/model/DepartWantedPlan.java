package com.jvwl.train.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jvwl.train.model.base.BaseBean;

/**
 * 部门招聘计划表
 * 
 * @author liuxin
 * 
 */
@Entity
public class DepartWantedPlan extends BaseBean {

	/**
	 * SEQ
	 */
	private String seq;
	/**
	 * 计划年度
	 */
	private String year;
	/**
	 * 计划部门
	 */
	private Department department;
	/**
	 * 最后修改日期
	 */
	private Date proposalDate;
	/**
	 * 需求人数
	 */
	private Integer neededNum;
	/**
	 * 需求岗位
	 */
	private Job job;
	/**
	 * 希望到岗日期
	 */
	private String hopeMonth;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 登陆者
	 */
	private String insertId;
	/**
	 * 登陆日期
	 */
	private Date insertDate;
	/**
	 * 更新者
	 */
	private String updateId;
	/**
	 * 更新日期
	 */
	private Date updateDate;

	@Column(unique = true, length = 20)
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	@Column(length = 4, nullable = false)
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@ManyToOne
	@JoinColumn(name = "department_id")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getProposalDate() {
		return proposalDate;
	}

	public void setProposalDate(Date proposalDate) {
		this.proposalDate = proposalDate;
	}

	public Integer getNeededNum() {
		return neededNum;
	}

	public void setNeededNum(Integer neededNum) {
		this.neededNum = neededNum;
	}

	@ManyToOne
	@JoinColumn(name = "job_id")
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Column(length = 6)
	public String getHopeMonth() {
		return hopeMonth;
	}

	public void setHopeMonth(String hopeMonth) {
		this.hopeMonth = hopeMonth;
	}

	@Column(length = 100)
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(length = 20)
	public String getInsertId() {
		return insertId;
	}

	public void setInsertId(String insertId) {
		this.insertId = insertId;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	@Column(length = 20)
	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
