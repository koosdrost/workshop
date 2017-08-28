package jsonb.lab2;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Lab2 {

    public static Person JOHN_DOE = new Person("John", "Doe", null);
    public static Person ADA_LOVELACE = new Person("Ada", "Lovelace", LocalDate.of(1815, 12, 10));
    public static List<Person> PEOPLE = Arrays.asList(ADA_LOVELACE, JOHN_DOE);

    public static void main(String[] args) {

        JsonbConfig config = new JsonbConfig();
        config.withDateFormat("dd-MM-yyyy", new Locale("us", "US"));
        Jsonb jsonb = JsonbBuilder.create(config);

        System.out.println(jsonb.toJson(JOHN_DOE));
        System.out.println();
        System.out.println(jsonb.toJson(ADA_LOVELACE));
        System.out.println();
        System.out.println(jsonb.toJson(PEOPLE));
    }
}
