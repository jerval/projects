package com.jvwl.examination.dto;

import com.jvwl.examination.bean.YesNo;

public class ExaminationKeyDTO {
	
	private String question_id;// 所属试题
	private YesNo state;// 是否启用
	private YesNo correct;

	public YesNo getCorrect() {
		return correct;
	}

	public void setCorrect(YesNo correct) {
		this.correct = correct;
	}


	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String questionId) {
		question_id = questionId;
	}

	public YesNo getState() {
		return state;
	}

	public void setState(YesNo state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ExaminationKeyDTO [correct=" + correct 
				+ ", question_id=" + question_id + ", state=" + state + "]";
	}

}
