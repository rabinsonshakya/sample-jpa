package com.cubic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.CustomerEntity;

//import org.hibernate.cfg.Configuration;
//
//import com.hibernate.test1.Employee;

public class JPAFindRecordTest2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		// EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			System.out.println("Connection Established");

			CustomerEntity entity = em.find(CustomerEntity.class, new Long(1005));

			System.out.println("Customer Entity = " + entity);
			// em.persist(entity);
			// et.commit();
			// System.out.println("After Insert = " + entity);

		} catch (Exception e) {
			e.printStackTrace();

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

	// private static CustomerEntity createCustomerEntity() {
	//
	// CustomerEntity entity = new CustomerEntity();
	// entity.setFirstName("Ethan");
	// entity.setLastName("Hunt");
	// entity.setSsn("123352345");
	// return entity;
	//
	// }

}
