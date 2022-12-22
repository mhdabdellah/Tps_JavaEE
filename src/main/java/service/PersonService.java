package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.Person;

// @Stateless
public class PersonService {

  @PersistenceContext
  private EntityManager entityManager;

  /**
 * @param employee
 */
public boolean createPerson(Person person) {
    try{
    	entityManager.persist(person);
    	return true;
    }catch(Exception e){
    	System.out.println(e);
    	return false;
    }
    
  }

  public void updatePerson(Person person) {
    entityManager.merge(person);
  }

  public void deletePerson(int id) {
	Person person = entityManager.find(Person.class, id);
    if (person != null) {
      entityManager.remove(person);
    }
  }

  public Person getPerson(int id) {
    return entityManager.find(Person.class, id);
  }

  public List<Person> getAllPersons() {
    TypedQuery<Person> query = entityManager.createQuery("SELECT e FROM person e", Person.class);
    return query.getResultList();
  }

public EntityManager getEntityManager() {
    return entityManager;
}

public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
}
}