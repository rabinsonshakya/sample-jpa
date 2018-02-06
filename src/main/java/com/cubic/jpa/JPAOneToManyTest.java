package com.cubic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.CustomerEntity;
import com.cubic.jpa.entity.OrderEntity;

//import org.hibernate.cfg.Configuration;
//
//import com.hibernate.test1.Employee;

public class JPAOneToManyTest {
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
			final CustomerEntity customer = createCustomerEntity();

			for (int i = 0; i < 5; i++) {
				OrderEntity ord = createOrderEntity("ORD-" + i);
				ord.setCustomer(customer);
				customer.getOrders().add(ord);
			}

			System.out.println("Before Insert = " + customer);
			em.persist(customer);
			et.commit();
			System.out.println("After Insert = " + customer);

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

		final CustomerEntity entity = new CustomerEntity();
		entity.setFirstName("Bruce");
		entity.setLastName("Hunt");
		entity.setSsn("123352345");
		return entity;

	}

	private static OrderEntity createOrderEntity(final String ordNumber) {

		final OrderEntity entity = new OrderEntity();
		entity.setOrderNumber(ordNumber);
		return entity;

	}

}
