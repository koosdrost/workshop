package jsonb.lab1;

import java.time.LocalDate;

public class Person {

	public String firstName;
	private String lastName;
	public LocalDate dateOfBirth;

	public Person() {
		// constructor to help default JSON-B handling work out of the box...
	}

	public Person(String firstName, String lastName, LocalDate dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return String.format("Person[first=%s, last=%s, dateOfBirth=%s]", firstName, lastName, dateOfBirth);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
