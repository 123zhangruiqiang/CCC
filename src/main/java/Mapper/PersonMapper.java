package Mapper;

import java.util.List;

import POJO.Person;
import POJO.PersonCustom;
import POJO.PersonQueryVo;

public interface PersonMapper {

		public Person findPersonById(int id);
		//public PersonCustom findPersonList(PersonQueryVo personQueryVo);
		public int findPersonCount(PersonQueryVo personQueryVo);
		public Person findPersonByIdResultMap(int id);
		public  List<PersonCustom> findPersonListById(PersonQueryVo personQueryVo);
		public List<PersonCustom> findPersonList(PersonQueryVo personQueryVo);
		public void updatePerson(Person person);
}
