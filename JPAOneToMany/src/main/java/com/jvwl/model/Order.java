package com.jvwl.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_order")
public class Order {

	private String orderId;
	private Float amount=0f;
	private Set<OrderItem> items = new HashSet<OrderItem>();

	@Id @Column(length=40)
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Column(nullable=false)
	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	@OneToMany(cascade={CascadeType.ALL},
			mappedBy="order")
	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public void addOrderItem(OrderItem orderItem){
		orderItem.setOrder(this);
		items.add(orderItem);
	}
}
