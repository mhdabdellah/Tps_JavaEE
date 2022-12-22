package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import models.Person;


public class Test {
	 public static void main( String[] args )
	    {
	        System.out.println( "Hello World!" );
	        
//	        String hibernatePropsFilePath = "hibernate.cfg.xml";
//	        File hibernatePropsFile = new File(hibernatePropsFilePath);
	//
////	        Configuration configuration = new Configuration(); 
////	        configuration.configure(hibernatePropsFile);
	//
//	        
//	        // Create a configuration object
//	        Configuration config = new Configuration().configure(hibernatePropsFile);
	//
//	        // Create a session factory
//	        SessionFactory factory = config.buildSessionFactory();
	//
//	        // Create a session
//	        Session session = factory.openSession();
	        
//	        String hibernatePropsFilePath = "hibernate.cfg.xml";
//	        File hibernatePropsFile = new File(hibernatePropsFilePath);

	        Configuration configuration = new Configuration(); 
	        configuration.configure("hibernate.cfg.xml");
	        configuration.addAnnotatedClass(models.Person.class);

	        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

	        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

	        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	        
	        // Create a session
	        Session session = sessionFactory.openSession();

	        // Create a new object
	        // User user = new User();
	        // user.setName("John Smith");
	        // user.setEmail("john@example.com");
	        Person person = new Person();
	        person.setNom("Mohamed Abdellahi");
	        person.setAdress("mhdabdellahi@gmail.com");;
//	        person.setId(6);
	        person.setPassword("sidi1212");
			
			System.out.println(person);
			System.out.println(person.getId());
	        // Save the object to the database
	        Transaction transaction = session.beginTransaction();
	        session.save(person);
	        if(session.isConnected()) {
	        	System.out.println("la connection est realisee par hibernate");
	        }else {
	        	System.out.println("la connection est realisee par hibernate");
	        }
	        transaction.commit();

	        // Close the session
	        session.close();
	    }
}
