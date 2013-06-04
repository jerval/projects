package com.jvwl.forum.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jvwl.forum.bean.YesNo;
import com.jvwl.forum.model.base.BaseBean;

@Entity
@Table(name = "t_topic")
public class Topic extends BaseBean {
	private String topicName;// 主题名称
	private Board board;// 版块名称
	private Member createMember;// 创建者（会员）
	private String content;// 内容
	private Integer skipCount;// 浏览次数
	private Integer replyCount;// 回复次数
	private YesNo isuse;// 是否启用
	private User validUser;// 验证人（用户）

	@Column(nullable = false, length = 200)
	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "board_id")
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	@ManyToOne(optional = false)
	@JoinColumn(nullable = false, name = "member_id")
	public Member getCreateMember() {
		return createMember;
	}

	public void setCreateMember(Member createMember) {
		this.createMember = createMember;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(nullable = false)
	public Integer getSkipCount() {
		return skipCount;
	}

	public void setSkipCount(Integer skipCount) {
		this.skipCount = skipCount;
	}

	@Column(nullable = false)
	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	@Enumerated(EnumType.ORDINAL)
	public YesNo getIsuse() {
		return isuse;
	}

	public void setIsuse(YesNo isuse) {
		this.isuse = isuse;
	}

	@ManyToOne
	@JoinColumn(name = "valid_user_id")
	public User getValidUser() {
		return validUser;
	}

	public void setValidUser(User validUser) {
		this.validUser = validUser;
	}

	@Override
	public String toString() {
		return "Topic [board=" + board + ", content=" + content
				+ ", createMember=" + createMember + ", isuse=" + isuse
				+ ", replyCount=" + replyCount + ", skipCount=" + skipCount
				+ ", topicName=" + topicName + ", validUser=" + validUser
				+ ", dateCreated=" + dateCreated + ", dateUpdate=" + dateUpdate
				+ ", deleted=" + deleted + ", id=" + id + ", version="
				+ version + "]";
	}

}
