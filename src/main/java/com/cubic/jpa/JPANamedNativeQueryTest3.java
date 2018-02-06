package com.cubic.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.QueryConstant1;

//import org.hibernate.cfg.Configuration;
//
//import com.hibernate.test1.Employee;

public class JPANamedNativeQueryTest3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		// EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			System.out.println("Connection Established");
			// String sqlQuery = "select c from CustomerEntity c";
			final BigDecimal result = (BigDecimal) em.createNamedQuery(QueryConstant1.N_CUSTOMER_COUNT)
					.getSingleResult();
			System.out.println("Result Count: " + result.intValue());

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
