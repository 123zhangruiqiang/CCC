package Service.imp;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import DAO.PersonDao;
import Mapper.PersonMapper;
import POJO.Person;
import Service.PersonService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImp implements PersonService {

	@Autowired
	private PersonMapper pm;

	public Person findPersonByIdResultMap(int id) {
		
		return pm.findPersonById(1);
	}
	@Transactional(rollbackFor = Exception.class)
	public void updatePerson(Person person) {
		 pm.updatePerson(person);

	}


}
