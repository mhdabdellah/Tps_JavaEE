package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import models.Person;

public class cong {

	public boolean createPerson(Person person) {
		try {
			 Configuration configuration = new Configuration(); 
		     configuration.configure("hibernate.cfg.xml");
		     configuration.addAnnotatedClass(models.Person.class);
	
		     StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	         ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
	
		     SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		        
		     // Create a session
		     Session session = sessionFactory.openSession();
		        
		     Transaction transaction = session.beginTransaction();
		     session.save(person);
		     transaction.commit();
	
		     // Close the session
		     session.close();
		     sessionFactory.close();
		     return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	       
}