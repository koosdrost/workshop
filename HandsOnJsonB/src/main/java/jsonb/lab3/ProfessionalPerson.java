package jsonb.lab3;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTypeAdapter;

import jsonb.lab3.external.library.UnmappablePerson;

public class ProfessionalPerson {

	@JsonbTypeAdapter(UnmappablePersonAdapter.class)
	private UnmappablePerson person;
	private String profession;

	@JsonbCreator
	public ProfessionalPerson(@JsonbProperty("person") UnmappablePerson person,
			@JsonbProperty("profession") String profession) {
		this.person = person;
		this.profession = profession;
	}

	@Override
	public String toString() {
		return String.format("Professional[%s, %s]", person, profession);
	}

	public UnmappablePerson getPerson() {
		return person;
	}

	public String getProfession() {
		return profession;
	}
}
