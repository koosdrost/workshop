package jsonb.lab1;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Lab1 {

    public static Person JOHN_DOE = new Person("John", "Doe", null);
    public static Person ADA_LOVELACE = new Person("Ada", "Lovelace", LocalDate.of(1815, 12, 10));
    public static List<Person> PEOPLE_LIST = Arrays.asList(ADA_LOVELACE, JOHN_DOE);

    public static void main(String[] args) {

        Jsonb jsonb = JsonbBuilder.create();
        String json = jsonb.toJson(JOHN_DOE);

        System.out.println(json);

        Person p = jsonb.fromJson("{\"firstName\":\"Charles\",\"lastName\":\"Babbage\"}", Person.class);
        System.out.println(p);
    }
}
