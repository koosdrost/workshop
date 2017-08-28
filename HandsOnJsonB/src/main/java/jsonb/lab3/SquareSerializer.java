package jsonb.lab3;

import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

public class SquareSerializer implements JsonbSerializer<Square> {

	@Override
	public void serialize(Square obj, JsonGenerator generator, SerializationContext ctx) {
		generator.writeStartObject().writeKey("square").writeStartObject().writeKey("side").write(obj.getSide())
				.writeEnd().writeEnd();
	}
}
