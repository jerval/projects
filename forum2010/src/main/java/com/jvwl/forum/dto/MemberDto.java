package com.jvwl.forum.dto;

import java.util.Date;

import com.jvwl.forum.bean.YesNo;

public class MemberDto {
	private String nikename;// 昵称
	private Integer level;// 最低等级
	private Integer level2;// 最高等级
	private Integer score;// 最低积分
	private Integer score2;// 最高积分
	private Date birthday;// 起始生日
	private Date birthday2;// 结束生日
	private YesNo ismale;// 性别

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getLevel2() {
		return level2;
	}

	public void setLevel2(Integer level2) {
		this.level2 = level2;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScore2() {
		return score2;
	}

	public void setScore2(Integer score2) {
		this.score2 = score2;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getBirthday2() {
		return birthday2;
	}

	public void setBirthday2(Date birthday2) {
		this.birthday2 = birthday2;
	}

	public YesNo getIsmale() {
		return ismale;
	}

	public void setIsmale(YesNo ismale) {
		this.ismale = ismale;
	}

	@Override
	public String toString() {
		return "MemberDto [birthday=" + birthday + ", birthday2=" + birthday2
				+ ", ismale=" + ismale + ", level=" + level + ", level2="
				+ level2 + ", nikename=" + nikename + ", score=" + score
				+ ", score2=" + score2 + "]";
	}

}
