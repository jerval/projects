package com.jvwl.examination.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jvwl.examination.bean.YesNo;

/**
 * 保存试卷信息的javabean
 * 
 * @author 蹇伟
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_examination_paper")
public class ExaminationPaper extends BaseBean {

	private String paper_id;// 试卷ID
	private String paper_name;// 试卷名称
	private Department department;// 所属部门
	private String info; // 试卷简介
	private Integer answerTime; // 作答时间
	private YesNo state;// 是否启用

	@Column(nullable = false, length = 20, unique = true)
	public String getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(String paperId) {
		paper_id = paperId;
	}

	@Column(nullable = false, length = 30)
	public String getPaper_name() {
		return paper_name;
	}

	public void setPaper_name(String paperName) {
		paper_name = paperName;
	}

	@ManyToOne(cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "department_id")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(nullable = false)
	public Integer getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(Integer answerTime) {
		this.answerTime = answerTime;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false,length=2)
	public YesNo getState() {
		return state;
	}

	public void setState(YesNo state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((paper_id == null) ? 0 : paper_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExaminationPaper other = (ExaminationPaper) obj;
		if (paper_id == null) {
			if (other.paper_id != null)
				return false;
		} else if (!paper_id.equals(other.paper_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExaminationPaper [answerTime=" + answerTime + ", department="
				+ department + ", info=" + info + ", paper_id=" + paper_id
				+ ", paper_name=" + paper_name + ", state=" + state
				+ ", dateCreated=" + dateCreated + ", dateUpdate=" + dateUpdate
				+ ", id=" + id + ", version=" + version + "]";
	}

}
