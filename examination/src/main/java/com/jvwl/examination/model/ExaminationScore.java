package com.jvwl.examination.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.jvwl.examination.util.TimeUtil;

/**
 * 保存成绩信息的javabean
 * 
 * @author 蹇伟
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_examination_score")
public class ExaminationScore extends BaseBean {

	private Employee employee;// 所属员工
	private ExaminationPaper paper;// 试卷
	private Date date;// 作答日期
	private Integer answerTime;// 答卷用时
	private Float score;// 成绩

	@ManyToOne(cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "employee_id")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "examinationpaper_id")
	public ExaminationPaper getPaper() {
		return paper;
	}

	public void setPaper(ExaminationPaper paper) {
		this.paper = paper;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	public Date getDate() {
		return date;
	}

	@Transient
	public String getStrDate() {
		return TimeUtil.getDateTime(date);
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(nullable = false)
	public Integer getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(Integer answerTime) {
		this.answerTime = answerTime;
	}

	@Column(nullable = false)
	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ExaminationScore [answerTime=" + answerTime + ", date=" + date
				+ ", employee=" + employee + ", paper=" + paper + ", score="
				+ score + ", dateCreated=" + dateCreated + ", dateUpdate="
				+ dateUpdate + ", id=" + id + ", version=" + version + "]";
	}

}
