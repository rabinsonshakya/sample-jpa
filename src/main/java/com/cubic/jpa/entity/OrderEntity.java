package com.cubic.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_ORDER")

public class OrderEntity {
	@Id
	@Column(name = "ORDER_ID")
	@SequenceGenerator(name = "orderSeq", sequenceName = "JPA_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "orderSeq")
	private Long pk;

	@Column(name = "ORDER_NUMBER")
	private String orderNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_FK")
	private CustomerEntity customer;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "OrderEntity [pk=" + pk + ", orderNumber=" + orderNumber + "]";
	}

}
