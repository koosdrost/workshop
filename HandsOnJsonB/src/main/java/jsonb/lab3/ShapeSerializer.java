package jsonb.lab3;

import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerationException;
import javax.json.stream.JsonGenerator;

public class ShapeSerializer implements JsonbSerializer<Shape> {

	@Override
	public void serialize(Shape obj, JsonGenerator generator, SerializationContext ctx) {
		if (obj instanceof Square) {
			serializeSquare((Square) obj, generator, ctx);
		} else if (obj instanceof Rectangle) {
			serializeRectangle((Rectangle) obj, generator, ctx);
		} else if (obj instanceof Circle) {
			serializeCircle((Circle) obj, generator, ctx);
		} else {
			throw new JsonGenerationException(
					"Serializing Shapes of type " + obj.getClass().getName() + " is not supported (yet)");
		}
	}

	private void serializeSquare(Square square, JsonGenerator generator, SerializationContext ctx) {
		generator.writeStartObject().writeKey("square").writeStartObject().writeKey("side").write(square.getSide())
				.writeEnd().writeEnd();
	}

	private void serializeRectangle(Rectangle rectangle, JsonGenerator generator, SerializationContext ctx) {
		generator.writeStartObject().writeKey("rectangle").writeStartObject().writeKey("height")
				.write(rectangle.getHeight()).writeKey("width").write(rectangle.getWidth()).writeEnd().writeEnd();
	}

	private void serializeCircle(Circle circle, JsonGenerator generator, SerializationContext ctx) {
		generator.writeStartObject().writeKey("circle").writeStartObject().writeKey("radius").write(circle.getRadius())
				.writeEnd().writeEnd();
	}
}
