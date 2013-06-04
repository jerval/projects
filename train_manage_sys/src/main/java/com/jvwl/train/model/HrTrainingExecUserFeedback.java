package com.jvwl.train.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jvwl.train.model.base.BaseBean;

/**
 * 培训人员和培训反馈表详细
 * 
 * @author wangchan
 */
@Entity
public class HrTrainingExecUserFeedback extends BaseBean {

	/**
	 *培训ID
	 */
	private Job job;
	/**
	 * 培训课程编号
	 */
	private HrTrainingExecDetail hrTrainingExecDetall;
	/**
	 * 受训员工
	 */
	private Staff staff;
	/**
	 * 必须受训标志
	 */
	private String needsitinFlag;
	/**
	 * 受训标志
	 */
	private String sitinFlag;
	/**
	 * 老师印象
	 */
	private String teacherEvl;
	/**
	 * 考核分值
	 */
	private String trainingCounter;
	/**
	 * 评价自己
	 */
	private String selfEvl;
	/**
	 * 评价老师
	 */
	private String evlTeacher;
	/**
	 * 改善建议
	 */
	private String studentAdvise;
	/**
	 * 登陆者
	 */
	private String insertID;
	/**
	 * 登陆日期
	 */
	private Date insertDate;
	/**
	 * 更新者
	 */
	private String updateID;
	/**
	 * 更新日期
	 */
	private Date updateDate;

	@ManyToOne
	@JoinColumn(name = "jobID")
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@ManyToOne
	@JoinColumn(name = "courseID")
	public HrTrainingExecDetail getHrTrainingExecDetall() {
		return hrTrainingExecDetall;
	}

	public void setHrTrainingExecDetall(
			HrTrainingExecDetail hrTrainingExecDetall) {
		this.hrTrainingExecDetall = hrTrainingExecDetall;
	}

	@ManyToOne
	@JoinColumn(name = "userID")
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Column(length = 10)
	public String getNeedsitinFlag() {
		return needsitinFlag;
	}

	public void setNeedsitinFlag(String needsitinFlag) {
		this.needsitinFlag = needsitinFlag;
	}

	@Column(length = 10)
	public String getSitinFlag() {
		return sitinFlag;
	}

	public void setSitinFlag(String sitinFlag) {
		this.sitinFlag = sitinFlag;
	}

	@Column(length = 1000)
	public String getTeacherEvl() {
		return teacherEvl;
	}

	public void setTeacherEvl(String teacherEvl) {
		this.teacherEvl = teacherEvl;
	}

	@Column(length = 6)
	public String getTrainingCounter() {
		return trainingCounter;
	}

	public void setTrainingCounter(String trainingCounter) {
		this.trainingCounter = trainingCounter;
	}

	@Column(length = 6)
	public String getSelfEvl() {
		return selfEvl;
	}

	public void setSelfEvl(String selfEvl) {
		this.selfEvl = selfEvl;
	}

	@Column(length = 200)
	public String getEvlTeacher() {
		return evlTeacher;
	}

	public void setEvlTeacher(String evlTeacher) {
		this.evlTeacher = evlTeacher;
	}

	@Column(length = 1000)
	public String getStudentAdvise() {
		return studentAdvise;
	}

	public void setStudentAdvise(String studentAdvise) {
		this.studentAdvise = studentAdvise;
	}

	@Column(length = 20)
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
	@Column(length = 20)
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

}
