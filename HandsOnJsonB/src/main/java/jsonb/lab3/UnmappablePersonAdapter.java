package jsonb.lab3;

import javax.json.bind.adapter.JsonbAdapter;

import jsonb.lab1.Person;
import jsonb.lab3.external.library.Name;
import jsonb.lab3.external.library.UnmappablePerson;

public class UnmappablePersonAdapter implements JsonbAdapter<UnmappablePerson, Person> {

	@Override
	public Person adaptToJson(UnmappablePerson obj) throws Exception {
		return new Person(obj.getName().getFirst(), obj.getName().getLast(), obj.getBirthDate());
	}

	@Override
	public UnmappablePerson adaptFromJson(Person obj) throws Exception {
		return new UnmappablePerson(new Name(obj.firstName, obj.getLastName()), obj.dateOfBirth);
	}
}
