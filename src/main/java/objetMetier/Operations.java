package objetMetier;
import java.util.ArrayList;

import models.Person;

public class Operations {
	
	private ArrayList<Person> persons = new ArrayList<Person>();

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}
	
	public void add(Person person) {
		this.persons.add(person);
	}
	
	public void remove(int id) {
		for(Person person : persons) {
			if(person.getId() == id) {
				persons.remove(id);
			}
		}
	}
	
	public ArrayList<Person> gettAll() {
		return this.persons;
	}
	
	

}
