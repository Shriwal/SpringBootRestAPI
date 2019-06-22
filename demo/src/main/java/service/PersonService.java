package service;

import java.util.Hashtable;
import org.springframework.stereotype.Service;
import model.Person;

@Service
public class PersonService 
{
	Hashtable<String, Person> persons = new Hashtable<String, Person>();
	
	public PersonService()
	{
		Person person = new Person();
		person.setId("1");
		person.setAge(21);
		person.setFirstName("Ankit");
		person.setLastName("Shriwal");
		
		persons.put("1", person);
		
		person = new Person();
		person.setId("2");
		person.setAge(32);
		person.setFirstName("Ajay");
		person.setLastName("Rana");
		
		persons.put("2", person);
		
	}
	
	public Person getPerson(String id)
	{
		if (persons.containsKey(id))
		{
			return persons.get(id);
		}
		else
		{
			return null;
		}
	}
	
	public Hashtable<String, Person> getAll()
	{
		return persons;
	}
}
