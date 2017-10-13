package Service;

import org.springframework.stereotype.Service;

import POJO.Person;

public interface PersonService {

	public Person findPersonByIdResultMap(int id);
	public void updatePerson(Person person);
}
