package com.jvwl.examination.dto;

import com.jvwl.examination.bean.YesNo;
import com.jvwl.examination.model.Department;

public class ExaminationPaperDTO {

	private String paper_id;// 试卷ID
	private String paper_name;// 试卷名称
	private Department department;// 所属部门
	private Integer answerTime1; // 作答时间
	private Integer answerTime2; // 作答时间
	private YesNo state;// 是否启用

	public String getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(String paperId) {
		paper_id = paperId;
	}

	public String getPaper_name() {
		return paper_name;
	}

	public void setPaper_name(String paperName) {
		paper_name = paperName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getAnswerTime1() {
		return answerTime1;
	}

	public void setAnswerTime1(Integer answerTime1) {
		this.answerTime1 = answerTime1;
	}

	public Integer getAnswerTime2() {
		return answerTime2;
	}

	public void setAnswerTime2(Integer answerTime2) {
		this.answerTime2 = answerTime2;
	}

	public YesNo getState() {
		return state;
	}

	public void setState(YesNo state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ExaminationPaperDTO [answerTime1=" + answerTime1
				+ ", answerTime2=" + answerTime2 + ", department=" + department
				+ ", paper_id=" + paper_id + ", paper_name=" + paper_name
				+ ", state=" + state + "]";
	}

}
