package com.hibernate.test1;

import org.hibernate.cfg.Configuration;

//import com.fasterxml.classmate.AnnotationConfiguration;

public class TestEmployee {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.addAnnotatedClass(Employee.class);
		config.configure();

		// SchemaExport se = new SchemaExport();
		// se.create(null, true);
	}

}
