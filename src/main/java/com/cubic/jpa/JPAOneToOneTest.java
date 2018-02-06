package com.cubic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.CustomerDetail;
import com.cubic.jpa.entity.CustomerEntity;

//import org.hibernate.cfg.Configuration;
//
//import com.hibernate.test1.Employee;

public class JPAOneToOneTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		String s1 = String.format("%.1f", 100.59999);
		System.out.println(s1);

		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			System.out.println("Connection Established");

			et = em.getTransaction();
			et.begin();
			final CustomerEntity entity = createCustomerEntity();
			final CustomerDetail detailEntity = createCustomerDetailEntity();

			entity.setCustomerDetail(detailEntity);
			detailEntity.setCustomer(entity);

			System.out.println("Before Insert = " + entity);
			em.persist(entity);
			et.commit();
			System.out.println("After Insert = " + entity);

		} catch (Exception e) {
			e.printStackTrace();

			if (et != null)
				et.setRollbackOnly();
		} finally {
			if (em != null) {
				em.close();
			}

			if (emf != null) {
				emf.close();
			}
		}

		// Configuration config = new Configuration();
		// config.addAnnotatedClass(Employee.class);
		// config.configure();
	}

	private static CustomerEntity createCustomerEntity() {

		CustomerEntity entity = new CustomerEntity();
		entity.setFirstName("Bruce");
		entity.setLastName("Hunt");
		entity.setSsn("123352345");
		return entity;

	}

	private static CustomerDetail createCustomerDetailEntity() {

		CustomerDetail entity = new CustomerDetail();
		entity.setDescription("This is one to one  ");
		return entity;

	}

}
