package com.jvwl.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	private Integer id;
	private String name;
	private IDCard idCard;

	public Person() {
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "idCard_id")
	public IDCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
	}

}
