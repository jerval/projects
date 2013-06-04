package com.jvwl.forum.dto;

import com.jvwl.forum.bean.YesNo;

public class TopicDto {
	private String topicName;// 主题名称
	private String boardName;// 版块名称
	private String createMemberName;// 创建者（会员）
	private Integer skipCount;// 浏览次数下限
	private Integer skipCount2;// 浏览次数上限
	private Integer replyCount;// 回复次数下限
	private Integer replyCount2;// 回复次数上限
	private YesNo isuse;// 是否启用
	private String validUserName;// 验证人（用户）

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getCreateMemberName() {
		return createMemberName;
	}

	public void setCreateMemberName(String createMemberName) {
		this.createMemberName = createMemberName;
	}

	public Integer getSkipCount() {
		return skipCount;
	}

	public void setSkipCount(Integer skipCount) {
		this.skipCount = skipCount;
	}

	public Integer getSkipCount2() {
		return skipCount2;
	}

	public void setSkipCount2(Integer skipCount2) {
		this.skipCount2 = skipCount2;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public Integer getReplyCount2() {
		return replyCount2;
	}

	public void setReplyCount2(Integer replyCount2) {
		this.replyCount2 = replyCount2;
	}

	public YesNo getIsuse() {
		return isuse;
	}

	public void setIsuse(YesNo isuse) {
		this.isuse = isuse;
	}

	public String getValidUserName() {
		return validUserName;
	}

	public void setValidUserName(String validUserName) {
		this.validUserName = validUserName;
	}

	@Override
	public String toString() {
		return "TopicDto [boardName=" + boardName + ", createMemberName="
				+ createMemberName + ", isuse=" + isuse + ", replyCount="
				+ replyCount + ", replyCount2=" + replyCount2 + ", skipCount="
				+ skipCount + ", skipCount2=" + skipCount2 + ", topicName="
				+ topicName + ", validUserName=" + validUserName + "]";
	}

}
