package com.cubic.jpa.entity;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class LoggingListener {

	@PrePersist
	public void beforeInsert(final CustomerEntity entity) {
		System.out.println("@PrePersist = " + entity);
	}

	@PostPersist
	public void afterInsert(final CustomerEntity entity) {
		System.out.println("@PostPersist = " + entity);
	}

}
