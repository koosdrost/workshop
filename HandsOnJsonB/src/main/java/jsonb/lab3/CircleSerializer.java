package jsonb.lab3;

import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

public class CircleSerializer implements JsonbSerializer<Circle> {

	@Override
	public void serialize(Circle obj, JsonGenerator generator, SerializationContext ctx) {
		generator.writeStartObject().writeKey("circle").writeStartObject().writeKey("radius").write(obj.getRadius())
				.writeEnd().writeEnd();
	}
}
