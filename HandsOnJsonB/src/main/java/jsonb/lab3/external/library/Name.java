package jsonb.lab3.external.library;

public class Name {

	private String first;
	private String last;

	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

	@Override
	public String toString() {
		return String.format("Name[%s, %s]", first, last);
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}
}
