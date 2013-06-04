package com.jvwl.train.dto;

import java.util.Date;

import com.jvwl.train.model.base.BaseBean;

/**
 * 培训人员和培训反馈表详细
 * 
 * @author wangchan
 */
public class HrTrainingExecUserFeedbackDto extends BaseBean {

	/**
	 *培训ID
	 */
	private JobDto job;
	/**
	 * 培训课程编号
	 */
	private HrTrainingExecDetailDto hrTrainingExecDetall;
	/**
	 * 受训员工
	 */
	private StaffDto staff;
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

	public JobDto getJob() {
		return job;
	}

	public void setJob(JobDto job) {
		this.job = job;
	}

	public HrTrainingExecDetailDto getHrTrainingExecDetall() {
		return hrTrainingExecDetall;
	}

	public void setHrTrainingExecDetall(
			HrTrainingExecDetailDto hrTrainingExecDetall) {
		this.hrTrainingExecDetall = hrTrainingExecDetall;
	}

	public StaffDto getStaff() {
		return staff;
	}

	public void setStaff(StaffDto staff) {
		this.staff = staff;
	}

	public String getNeedsitinFlag() {
		return needsitinFlag;
	}

	public void setNeedsitinFlag(String needsitinFlag) {
		this.needsitinFlag = needsitinFlag;
	}

	public String getSitinFlag() {
		return sitinFlag;
	}

	public void setSitinFlag(String sitinFlag) {
		this.sitinFlag = sitinFlag;
	}

	public String getTeacherEvl() {
		return teacherEvl;
	}

	public void setTeacherEvl(String teacherEvl) {
		this.teacherEvl = teacherEvl;
	}

	public String getTrainingCounter() {
		return trainingCounter;
	}

	public void setTrainingCounter(String trainingCounter) {
		this.trainingCounter = trainingCounter;
	}

	public String getSelfEvl() {
		return selfEvl;
	}

	public void setSelfEvl(String selfEvl) {
		this.selfEvl = selfEvl;
	}

	public String getEvlTeacher() {
		return evlTeacher;
	}

	public void setEvlTeacher(String evlTeacher) {
		this.evlTeacher = evlTeacher;
	}

	public String getStudentAdvise() {
		return studentAdvise;
	}

	public void setStudentAdvise(String studentAdvise) {
		this.studentAdvise = studentAdvise;
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

}
