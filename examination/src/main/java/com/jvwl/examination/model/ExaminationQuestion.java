package com.jvwl.examination.model;

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jvwl.examination.bean.PaperType;
import com.jvwl.examination.bean.YesNo;

/**
 * 保存员工信息的javabean
 * 
 * @author 蹇伟
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_examination_question")
public class ExaminationQuestion extends BaseBean {

	private String question_id;// 试题编号
	private ExaminationPaper paper;// 试卷编号
	private String content;// 试题内容
	private PaperType questionType;// 试题类型
	private Set<ExaminationKey> keys = new HashSet<ExaminationKey>();
	private Float score;// 所占分数
	private YesNo state;// 是否启用

	@OneToMany(cascade=CascadeType.REMOVE,mappedBy="question")
	public Set<ExaminationKey> getKeys() {
		return keys;
	}

	public void setKeys(Set<ExaminationKey> keys) {
		this.keys = keys;
	}

	@Column(nullable = false, unique = true, length = 30)
	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String questionId) {
		question_id = questionId;
	}

	@ManyToOne(cascade = CascadeType.REFRESH, optional = false)
	@JoinColumn(name = "paper_id")
	public ExaminationPaper getPaper() {
		return paper;
	}

	public void setPaper(ExaminationPaper paper) {
		this.paper = paper;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY, optional = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	public PaperType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(PaperType questionType) {
		this.questionType = questionType;
	}

	@Column(nullable = false)
	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
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
	public String toString() {
		return "ExaminationQuestion [content=" + content
				+ ", paper=" + paper + ", questionType=" + questionType
				+ ", question_id=" + question_id + ", score=" + score
				+ ", state=" + state + "]";
	}

}
