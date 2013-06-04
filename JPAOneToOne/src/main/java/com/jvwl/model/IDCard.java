package com.jvwl.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class IDCard {

	private Integer id;
	private String cardNo;
	private Person person;

	public IDCard() {
	}

	public IDCard(String cardNo) {
		super();
		this.cardNo = cardNo;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(nullable = false, length = 18)
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	@OneToOne(mappedBy = "idCard", cascade = { CascadeType.REFRESH,
			CascadeType.PERSIST, CascadeType.MERGE })
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
