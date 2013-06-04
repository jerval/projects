package com.jvwl.examination.dto;


public class ExaminationScoreDTO {

	private String employee_id;// 所属员工
	private String paper_id;// 试卷
	private String date1;// 作答日期
	private String date2;// 作答日期
	private Integer answerTime1;// 答卷用时
	private Integer answerTime2;// 答卷用时
	private Float score1;// 成绩
	private Float score2;// 成绩

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employeeId) {
		employee_id = employeeId;
	}

	public String getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(String paperId) {
		paper_id = paperId;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
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

	public Float getScore1() {
		return score1;
	}

	public void setScore1(Float score1) {
		this.score1 = score1;
	}

	public Float getScore2() {
		return score2;
	}

	public void setScore2(Float score2) {
		this.score2 = score2;
	}

	@Override
	public String toString() {
		return "ExaminationScoreDTO [answerTime1=" + answerTime1
				+ ", answerTime2=" + answerTime2 + ", date1=" + date1
				+ ", date2=" + date2 + ", employee_id=" + employee_id
				+ ", paper_id=" + paper_id + ", score1=" + score1 + ", score2="
				+ score2 + "]";
	}

}
