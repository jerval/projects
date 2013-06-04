package com.jvwl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_department")
public class Department extends BaseBean{

	private String depart_id;// 部门ID
	private String depart_name;// 部门名称
	private String depart_info;// 部门简介

	@Column(nullable=false,unique=true,length=20)	
	public String getDepart_id() {
		return depart_id;
	}

	public void setDepart_id(String departId) {
		depart_id = departId;
	}

	@Column(nullable=false,unique=true,length=40)	
	public String getDepart_name() {
		return depart_name;
	}

	public void setDepart_name(String departName) {
		depart_name = departName;
	}

	@Column(length=200)	
	public String getDepart_info() {
		return depart_info;
	}

	public void setDepart_info(String departInfo) {
		depart_info = departInfo;
	}

	@Override
	public String toString() {
		return "Department [depart_id=" + depart_id + ", depart_info="
				+ depart_info + ", depart_name=" + depart_name + "]";
	}

}
