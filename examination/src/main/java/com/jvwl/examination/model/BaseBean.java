package com.jvwl.examination.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.jvwl.examination.util.TimeUtil;

/**
 * 实体抽取的父类
 * 
 * @author 蹇伟
 * 
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class BaseBean implements Serializable {

	protected Integer id;
	protected Integer version;
	protected Date dateCreated;
	protected Date dateUpdate;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Version
	public Integer getVersion() {
		return version;
	}

	@PrePersist
	public void prePersist() {
		dateCreated = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		dateUpdate = new Date();
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name = "date_created", nullable = false)
	public Date getDateCreated() {
		return dateCreated;
	}

	@Transient
	public String getStrDateCreated() {
		return TimeUtil.getDateTime(dateCreated);
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Column(name = "date_update")
	public Date getDateUpdate() {
		return dateUpdate;
	}

	@Transient
	public String getStrDateUpdate() {
		return TimeUtil.getDateTime(dateUpdate);
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

}
