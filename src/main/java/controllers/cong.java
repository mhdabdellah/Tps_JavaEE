package controllers;

import org.hibernate.cfg.Configuration;

public class cong {

	Configuration configuration = new Configuration();
	configuration.addAnnotatedClass(Employee.class);
	configuration.addAnnotatedClass(Department.class);
	configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydatabase");
	configuration.setProperty("hibernate.connection.username", "user");
	configuration.setProperty("hibernate.connection.password", "password");
	configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.

}
