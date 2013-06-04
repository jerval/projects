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
@Table(name = "t_reply")
public class Reply extends BaseBean {

	private Member member;// 发贴会员
	private Topic topic;// 所属主题
	private Reply reply;// 回复某一条回复
	private Integer floor;//所属楼层
	private User validUser;// 验证用户
	private String content;// 回复内容
	private YesNo isuse;// 是否启用
	private Integer supportCount;// 支持数

	@ManyToOne(optional = false)
	@JoinColumn(nullable = false, name = "member_id")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@ManyToOne(optional = false)
	@JoinColumn(nullable = false, name = "topic_id")
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@ManyToOne
	@JoinColumn(name = "reply_id")
	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	@ManyToOne
	@JoinColumn(name = "valid_user_id")
	public User getValidUser() {
		return validUser;
	}

	public void setValidUser(User validUser) {
		this.validUser = validUser;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	public YesNo getIsuse() {
		return isuse;
	}

	public void setIsuse(YesNo isuse) {
		this.isuse = isuse;
	}

	@Column(nullable = false)
	public Integer getSupportCount() {
		return supportCount;
	}

	public void setSupportCount(Integer supportCount) {
		this.supportCount = supportCount;
	}

	@Override
	public String toString() {
		return "Reply [content=" + content + ", isuse=" + isuse + ", member="
				+ member + ", reply=" + reply + ", supportCount="
				+ supportCount + ", topic=" + topic + ", validUser="
				+ validUser + ", dateCreated=" + dateCreated + ", dateUpdate="
				+ dateUpdate + ", deleted=" + deleted + ", id=" + id
				+ ", version=" + version + "]";
	}

}
