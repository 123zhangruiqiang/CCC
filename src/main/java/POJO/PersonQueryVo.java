package POJO;

import java.util.List;

public class PersonQueryVo {
	private PersonCustom personCustom;
	
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public PersonCustom getPersonCustom() {
		return personCustom;
	}

	public void setPersonCustom(PersonCustom personCustom) {
		this.personCustom = personCustom;
	}
}
