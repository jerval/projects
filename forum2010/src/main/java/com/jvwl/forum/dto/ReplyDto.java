package com.jvwl.forum.dto;

import com.jvwl.forum.bean.YesNo;

public class ReplyDto {
	private String memberName;// 发贴会员
	private String topicName;// 所属主题
	private Integer floor;// 所属楼层下限
	private Integer floor2;// 所属楼层上限
	private String validUserName;// 验证用户
	private YesNo isuse;// 是否启用
	private Integer supportCount;// 支持数

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getFloor2() {
		return floor2;
	}

	public void setFloor2(Integer floor2) {
		this.floor2 = floor2;
	}

	public String getValidUserName() {
		return validUserName;
	}

	public void setValidUserName(String validUserName) {
		this.validUserName = validUserName;
	}

	public YesNo getIsuse() {
		return isuse;
	}

	public void setIsuse(YesNo isuse) {
		this.isuse = isuse;
	}

	public Integer getSupportCount() {
		return supportCount;
	}

	public void setSupportCount(Integer supportCount) {
		this.supportCount = supportCount;
	}

	@Override
	public String toString() {
		return "ReplyDto [floor=" + floor + ", floor2=" + floor2 + ", isuse="
				+ isuse + ", memberName=" + memberName + ", supportCount="
				+ supportCount + ", topicName=" + topicName
				+ ", validUserName=" + validUserName + "]";
	}

}
