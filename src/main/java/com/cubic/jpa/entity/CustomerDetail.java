package com.cubic.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CUSTOMER_INFO")
public class CustomerDetail {

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "detailSeq", strategy = "foreign", parameters = {
			@Parameter(name = "property", value = "customer") })
	@GeneratedValue(generator = "detailSeq")
	private Long detailPk;
	@Column(name = "description")
	private String description;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private CustomerEntity customer;

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public Long getDetailPk() {
		return detailPk;
	}

	public void setDetailPk(Long detailPk) {
		this.detailPk = detailPk;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CustomerDetail [detailPk=" + detailPk + ", description=" + description + "]";
	}

}
