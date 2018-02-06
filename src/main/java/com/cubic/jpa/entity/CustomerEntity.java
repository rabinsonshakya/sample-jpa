package com.cubic.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
@NamedQueries({ @NamedQuery(name = QueryConstant1.CUSTOMER_SELECT_ALL, query = "select c from CustomerEntity c"),
		@NamedQuery(name = QueryConstant1.CUSTOMER_SEARCH, query = "select c from CustomerEntity c where UPPER(c.firstName) like UPPER(:fName) AND UPPER(c.lastName) like UPPER(:lName)"),
		@NamedQuery(name = QueryConstant1.CUSTOMER_COUNT, query = "select count(c) from CustomerEntity c")

})

@NamedNativeQueries({
		@NamedNativeQuery(name = QueryConstant1.N_CUSTOMER_SELECT_ALL, query = "select * from CUSTOMER", resultClass = CustomerEntity.class),
		@NamedNativeQuery(name = QueryConstant1.N_CUSTOMER_SEARCH, query = "select c.CUSTOMER_ID,c.FIRST_NAME from CUSTOMER c where UPPER(c.FIRST_NAME) like UPPER(?) OR UPPER(c.LAST_NAME) like UPPER(?)"),
		@NamedNativeQuery(name = QueryConstant1.N_CUSTOMER_COUNT, query = "select COUNT(*) from CUSTOMER")

})
@EntityListeners({ LoggingListener.class, EncryptionListener.class })
public class CustomerEntity {

	@Id
	@SequenceGenerator(name = "cSeq", sequenceName = "JPA_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "cSeq")
	@Column(name = "CUSTOMER_ID")
	private Long pk;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "SSN")
	private String ssn;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private CustomerDetail customerDetail;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")

	private List<OrderEntity> orders;

	public List<OrderEntity> getOrders() {
		if (orders == null) {
			orders = new ArrayList<OrderEntity>();
		}
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "CustomerEntity [pk=" + pk + ", firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn
				+ "]";
	}

}
