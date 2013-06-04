package com.jvwl.train.model.base;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.jvwl.train.bean.YesNo;

/**
 * 实体父类
 * 
 * @author jerval
 */
@MappedSuperclass
public class BaseBean {
	/**
	 * 数据库编号
	 */
	protected Integer id;
	/**
	 * 创建时间
	 */
	protected Date dateCreated;
	/**
	 * 修改时间
	 */
	protected Date dateUpdate;
	/**
	 * 是否删除
	 */
	protected YesNo deleted = YesNo.否;

	@PrePersist
	public void prePersist() {
		dateCreated = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		dateUpdate = new Date();
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	@Enumerated(EnumType.ORDINAL)
	public YesNo getDeleted() {
		return deleted;
	}

	public void setDeleted(YesNo deleted) {
		this.deleted = deleted;
	}

}
