package jsonb.lab3.external.library;

import java.time.LocalDate;

/**
 * UnmappablePerson is a class from a supposed external library not under our
 * control.
 * <p>
 * This library is used in a context where we would like to JSON serialize
 * UnmappablePersons as follows:<br>
 * {"dateOfBirth":"1815-12-10","firstName":"Ada","lastName":"Lovelace"}
 */
public class UnmappablePerson {

	private Name name;
	private LocalDate birthdate;

	public UnmappablePerson(Name name, LocalDate birthdate) {
		this.name = name;
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return String.format("UnmappablePerson[%s, birthdate=%s]", name, birthdate);
	}

	public Name getName() {
		return name;
	}
	
	public LocalDate getBirthDate() {
		return birthdate;
	}
}
