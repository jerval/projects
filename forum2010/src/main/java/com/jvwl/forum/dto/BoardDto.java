package com.jvwl.forum.dto;

import com.jvwl.forum.bean.YesNo;

public class BoardDto {
	private String boardName; // 版块名称
	private String createUserName; // 创建版块的用户名
	private YesNo isuse; // 是否启用

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public YesNo getIsuse() {
		return isuse;
	}

	public void setIsuse(YesNo isuse) {
		this.isuse = isuse;
	}

	@Override
	public String toString() {
		return "BoardDto [boardName=" + boardName + ", createUserName="
				+ createUserName + ", isuse=" + isuse + "]";
	}

}
