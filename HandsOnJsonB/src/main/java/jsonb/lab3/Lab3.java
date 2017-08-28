package jsonb.lab3;

import java.util.Arrays;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

public class Lab3 {
	public static void main(String[] args) {

		JsonbConfig config = new JsonbConfig();
		// add the adapter or serializers/deserializer
		Jsonb jsonb = JsonbBuilder.create(config);

		List<Shape> shapes = Arrays.asList(new Square(2), new Rectangle(2, 3), new Circle(1));
		for (Shape shape : shapes) {
			System.out.println(jsonb.toJson(shape));
		}

		System.out.println();

		String jsonShapes = "[{\"square\":{\"side\":2.0}},{\"rectangle\":{\"height\":3.0,\"width\":2.0}},{\"circle\":{\"radius\":1.0}}]";

		System.out.println(jsonShapes);

		List<Shape> shapesDeserialized = jsonb.fromJson(jsonShapes, null /* ??? */);
		System.out.println(shapesDeserialized);
	}
}
