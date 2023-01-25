package ORM;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import models.Person;

public class ORMPerson {
	
	private Configuration configuration;
	private StandardServiceRegistryBuilder serviceRegistryBuilder ;
    private ServiceRegistry serviceRegistry;

//    private SessionFactory sessionFactory ; 
    // Create a session
    private SessionFactory sessionFactory ;
 	// Create a session
//    private Session session ;
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public ORMPerson() {
		super();
		configuration = new Configuration(); 
	    configuration.configure("hibernate.cfg.xml");
	    configuration.addAnnotatedClass(models.Person.class);
	    serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        serviceRegistry = serviceRegistryBuilder.build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	     
	}



	public boolean createPerson(Person person) {
		
		try {
			
			 
			 // Create a session
		     Session session = sessionFactory.openSession();
		     Transaction transaction = session.beginTransaction();
		     session.save(person);
		     transaction.commit();
	
		     // Close the session
		     session.close();
		     
		     return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public boolean updatePerson(Person person) {
//		entityManager.merge(person);
		try {
			
		     // Create a session
		     Session session = sessionFactory.openSession();
		        
		     Transaction transaction = session.beginTransaction();
		     Person newperson = session.get(Person.class, person.getId());
//		     Person newperson = session.byId(Person.class).getReference(person.getId());
		     newperson.setNom(person.getNom());
		     newperson.setAdress(person.getAdress());
		     newperson.setPassword(person.getPassword());
		     session.saveOrUpdate(newperson);
		     transaction.commit();
	
		     // Close the session
		     session.close();
		     return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean deletePerson(int id) {
		try {
			
		     // Create a session
		     Session session = sessionFactory.openSession();
		        
		     Transaction transaction = session.beginTransaction();
		     Person person = session.get(Person.class, id);
		  // Delete a persistent object
	         if (person != null) {
	             session.remove(person);
//	             System.out.println("student 1 is deleted");
	         }
//		     Person newperson = session.byId(Person.class).getReference(person.getId());
//		     newperson.setNom(person.getNom());
//		     newperson.setAdress(person.getAdress());
		     transaction.commit();
	
		     // Close the session
		     session.close();
		     return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public Person getPerson(int id) {
//		return entityManager.find(Person.class, id);
			
		     // Create a session
		     Session session = sessionFactory.openSession();
		        
		     Transaction transaction = session.beginTransaction();
		     Person person = session.get(Person.class, id);
		  // Delete a persistent object
//	         if (person != null) {
//	             session.remove(person);
////	             System.out.println("student 1 is deleted");
//	         }
//		     Person newperson = session.byId(Person.class).getReference(person.getId());
//		     newperson.setNom(person.getNom());
//		     newperson.setAdress(person.getAdress());
		     transaction.commit();
	
		     // Close the session
		     session.close();
		     return person;
	}

	public List<Person> getAllPersons() {
		
	     // Create a session
	     Session session = sessionFactory.openSession();
	        
	     Transaction transaction = session.beginTransaction();
	     TypedQuery<Person> query = session.createQuery("SELECT p FROM Person p",Person.class);
	     
	     List<Person> persons =  query.getResultList();
//	     SELECT p FROM Person p
	     transaction.commit();
	 	
	     // Close the session
	     session.close();
	     
	     return persons;
	}
	       
}