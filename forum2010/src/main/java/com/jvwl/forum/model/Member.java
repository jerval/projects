package com.jvwl.forum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.jvwl.forum.bean.YesNo;
import com.jvwl.forum.model.base.BaseBean;

@Entity
@Table(name = "t_member")
public class Member extends BaseBean {

	private String nikename;// 昵称
	private String password;// 密码
	private String repassword;
	private Integer level;// 等级
	private Integer score;// 积分
	private Date birthday;// 生日
	private YesNo ismale;// 性别

	@Transient
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	@Column(length = 20, nullable = false, unique = true)
	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	@Column(length = 30, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(nullable = false)
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(nullable = false)
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	public YesNo getIsmale() {
		return ismale;
	}

	public void setIsmale(YesNo ismale) {
		this.ismale = ismale;
	}

	@Override
	public String toString() {
		return "Member [birthday=" + birthday + ", ismale=" + ismale
				+ ", level=" + level + ", nikename=" + nikename + ", password="
				+ password + ", score=" + score + ", dateCreated="
				+ dateCreated + ", dateUpdate=" + dateUpdate + ", deleted="
				+ deleted + ", id=" + id + ", version=" + version + "]";
	}

}
