package com.cubic.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cubic.jpa.entity.CustomerEntity;
import com.cubic.jpa.entity.QueryConstant1;

//import org.hibernate.cfg.Configuration;
//
//import com.hibernate.test1.Employee;

public class JPANamedQueryTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		// EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			System.out.println("Connection Established");
			// String sqlQuery = "select c from CustomerEntity c";
			final TypedQuery<CustomerEntity> query = em.createNamedQuery(QueryConstant1.CUSTOMER_SEARCH,
					CustomerEntity.class);
			query.setParameter("fName", "j%");
			query.setParameter("lName", "b%");

			final List<CustomerEntity> resultList = query.getResultList();

			for (CustomerEntity entity : resultList) {
				System.out.println(entity);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (em != null) {

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