package com.cubic.jpa;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cubic.jpa.entity.QueryConstant1;

//import org.hibernate.cfg.Configuration;
//
//import com.hibernate.test1.Employee;

public class JPANamedNativeQueryTest2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		// EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			System.out.println("Connection Established");
			// String sqlQuery = "select c from CustomerEntity c";
			final TypedQuery<Object[]> query = (TypedQuery<Object[]>) em
					.createNamedQuery(QueryConstant1.N_CUSTOMER_SEARCH);
			query.setParameter(1, "j%");
			query.setParameter(2, "b%");
			final List<Object[]> resultList = query.getResultList();

			for (Object[] row : resultList) {
				final BigDecimal id = (BigDecimal) row[0];
				final String firstName = (String) row[1];
				System.out.println(id.intValue() + "==>" + firstName);
			}

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
