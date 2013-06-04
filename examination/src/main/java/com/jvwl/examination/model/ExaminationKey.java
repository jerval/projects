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
 * 保存员工信息的javabean
 * 
 * @author 蹇伟
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_examination_key")
public class ExaminationKey extends BaseBean {
	private String content;// 内容
	private YesNo correct;// 是否是正确选项
	private ExaminationQuestion question;// 所属试题
	private YesNo state;// 是否启用

	@Enumerated(EnumType.STRING)
	@Column(length = 2, nullable = false)
	public YesNo getCorrect() {
		return correct;
	}

	public void setCorrect(YesNo correct) {
		this.correct = correct;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 2, nullable = false)
	public YesNo getState() {
		return state;
	}

	public void setState(YesNo state) {
		this.state = state;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY, optional = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne(cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "examination_question_id")
	public ExaminationQuestion getQuestion() {
		return question;
	}

	public void setQuestion(ExaminationQuestion question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "ExaminationKey [content=" + content + ", correct=" + correct
				+ ", question=" + question + ", state="
				+ state + "]";
	}

}
