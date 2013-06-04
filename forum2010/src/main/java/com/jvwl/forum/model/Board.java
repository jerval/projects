package com.jvwl.forum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jvwl.forum.bean.YesNo;
import com.jvwl.forum.model.base.BaseBean;

@Entity
@Table(name="t_board")
public class Board extends BaseBean {

	private String boardName; // 版块名称
	private User createUser; // 创建版块的用户
	private String memo; // 版块简介
	private YesNo isuse; // 是否启用

	@Column(length = 200, nullable = false,unique=true)
	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	@ManyToOne(optional=false)
	@JoinColumn(name="create_user_id",nullable=false)
	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	@Column(length = 200, nullable = false)
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	public YesNo getIsuse() {
		return isuse;
	}

	public void setIsuse(YesNo isuse) {
		this.isuse = isuse;
	}

	@Override
	public String toString() {
		return "Board [boardName=" + boardName + ", createUser=" + createUser
				+ ", isuse=" + isuse + ", memo=" + memo + ", dateCreated="
				+ dateCreated + ", dateUpdate=" + dateUpdate + ", deleted="
				+ deleted + ", id=" + id + ", version=" + version + "]";
	}

}
