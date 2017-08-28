package jsonb.lab3;

import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

public class RectangleSerializer implements JsonbSerializer<Rectangle> {

	@Override
	public void serialize(Rectangle obj, JsonGenerator generator, SerializationContext ctx) {
		generator.writeStartObject().writeKey("rectangle").writeStartObject().writeKey("height").write(obj.getHeight())
				.writeKey("width").write(obj.getWidth()).writeEnd().writeEnd();
	}
}
