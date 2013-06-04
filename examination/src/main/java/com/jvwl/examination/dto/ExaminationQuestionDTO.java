package com.jvwl.examination.dto;

import com.jvwl.examination.bean.PaperType;
import com.jvwl.examination.bean.YesNo;
import com.jvwl.examination.model.ExaminationPaper;

public class ExaminationQuestionDTO {

	private String question_id;// 试题编号
	private ExaminationPaper paper;// 试卷编号
	private PaperType questionType;// 试题类型
	private Float score1;// 所占分数
	private Float score2;// 所占分数
	private YesNo state;// 是否启用

	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String questionId) {
		question_id = questionId;
	}

	public ExaminationPaper getPaper() {
		return paper;
	}

	public void setPaper(ExaminationPaper paper) {
		this.paper = paper;
	}

	public PaperType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(PaperType questionType) {
		this.questionType = questionType;
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

	public YesNo getState() {
		return state;
	}

	public void setState(YesNo state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ExaminationQuestionDTO [paper=" + paper + ", questionType="
				+ questionType + ", question_id=" + question_id + ", score1="
				+ score1 + ", score2=" + score2 + ", state=" + state + "]";
	}
	
}
