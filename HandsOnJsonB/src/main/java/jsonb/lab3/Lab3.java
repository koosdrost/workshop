package jsonb.lab3;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) {

        Jsonb jsonb = JsonbBuilder.create();
        JsonbConfig configWithAdapters = new JsonbConfig();
        //add the adapter
        configWithAdapters.withAdapters(new UnmappablePersonAdapter());
        Jsonb jsonbWithMapper = JsonbBuilder.create(configWithAdapters);

        JsonbConfig configWithSerializers = new JsonbConfig()
                .withSerializers(new SquareSerializer(), new RectangleSerializer(), new CircleSerializer()) // new
                .withDeserializers(new ShapeDeserializer());
        Jsonb jsonbWithSerializers = JsonbBuilder.create(configWithSerializers);


        List<Shape> shapes = Arrays.asList(new Square(2), new Rectangle(2, 3), new Circle(1));
        for (Shape shape : shapes) {
            System.out.println(jsonbWithSerializers.toJson(shape));
        }

        System.out.println();

        String jsonShapes = "[{\"square\":{\"side\":2.0}},{\"rectangle\":{\"height\":3.0,\"width\":2.0}},{\"circle\":{\"radius\":1.0}}]";

        System.out.println(jsonShapes);

        List<Shape> shapesDeserialized = jsonbWithSerializers.fromJson(jsonShapes, new ArrayList<Shape>() {
        }.getClass().getGenericSuperclass());
        System.out.println(shapesDeserialized);
    }
}
