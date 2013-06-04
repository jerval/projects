package com.jvwl.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseBean{
	private int id;
	private String name;

	@Id @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length=10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
