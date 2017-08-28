package jsonb.lab3;

import jsonb.lab3.external.library.UnmappablePerson;

/*
 * TODO use JsonbCreator, JsonbProperty and JsonbTypeAdapter annotations,
 * so that this class gets serialized with the UnmappablePerson like a Person
 * with a "plain" Jsonb (no special config: jsonb = JsonbBuilder.create()).
 */
public class ProfessionalPerson {

	private UnmappablePerson person;
	private String profession;

	public ProfessionalPerson(UnmappablePerson person, String profession) {
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
