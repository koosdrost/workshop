package jsonb.lab3;

import java.lang.reflect.Type;

import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.json.stream.JsonParsingException;

public class ShapeDeserializer implements JsonbDeserializer<Shape> {

	@Override
	public Shape deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
		// Event startShape = parser.next();
		// if (Event.START_OBJECT != startShape) {
		// throw new JsonParsingException(
		// "Unable to deserialize non JSON Object Shapes, expected START_OBJECT event,
		// got: " + startShape,
		// parser.getLocation());
		// }
		Event shapeKeyName = parser.next();
		if (Event.KEY_NAME != shapeKeyName) {
			throw new JsonParsingException(
					"Unable to deserialize JSON Object Shapes not starting with type key, got event: " + shapeKeyName,
					parser.getLocation());
		}

		String type = parser.getString();

		Event startShapeData = parser.next();
		if (Event.START_OBJECT != startShapeData) {
			throw new JsonParsingException(
					"Unable to deserialize non JSON Object Shape data, expected START_OBJECT event, got: "
							+ startShapeData,
					parser.getLocation());
		}

		Shape shape = null;
		switch (type) {
		case "square":
			shape = deserializeSquare(parser, ctx, rtType);
			break;
		case "rectangle":
			shape = deserializeRectangle(parser, ctx, rtType);
			break;
		case "circle":
			shape = deserializeCircle(parser, ctx, rtType);
			break;
		default:
			throw new JsonParsingException("Deserializing Shapes of type \"" + type + "\" is not (yet) implemented.",
					parser.getLocation());
		}
		return shape;
	}

	private Square deserializeSquare(JsonParser parser, DeserializationContext ctx, Type rtType) {
		Double side = null;
		boolean squareEnded = false;
		while (parser.hasNext() && !squareEnded) {
			Event next = parser.next();
			switch (next) {
			case END_OBJECT:
				squareEnded = true;
				break;
			case START_OBJECT:
				parser.skipObject();
				break;
			case START_ARRAY:
				parser.skipArray();
				break;
			case KEY_NAME:
				String key = parser.getString();
				if ("side".equals(key)) {
					Event sideValue = parser.next();
					if (Event.VALUE_NUMBER != sideValue) {
						throw new JsonParsingException(
								"Deserializing Square Shapes, side must be a number value, got: " + sideValue,
								parser.getLocation());
					}
					side = parser.getBigDecimal().doubleValue();
				}
				break;
			default:
				// ignore, continue
			}
		}

		if (side == null) {
			throw new JsonParsingException(
					"Deserializing Square Shapes, data object must contain number value \"side\".",
					parser.getLocation());
		}

		return new Square(side);
	}

	private Rectangle deserializeRectangle(JsonParser parser, DeserializationContext ctx, Type rtType) {
		Double height = null;
		Double width = null;
		boolean rectangleEnded = false;
		while (parser.hasNext() && !rectangleEnded) {
			Event next = parser.next();
			switch (next) {
			case END_OBJECT:
				rectangleEnded = true;
				break;
			case START_OBJECT:
				parser.skipObject();
				break;
			case START_ARRAY:
				parser.skipArray();
				break;
			case KEY_NAME:
				String key = parser.getString();
				if ("height".equals(key)) {
					Event heightValue = parser.next();
					if (Event.VALUE_NUMBER != heightValue) {
						throw new JsonParsingException(
								"Deserializing Rectangle Shapes, height must be a number value, got: " + heightValue,
								parser.getLocation());
					}
					height = parser.getBigDecimal().doubleValue();
				} else if ("width".equals(key)) {
					Event widthValue = parser.next();
					if (Event.VALUE_NUMBER != widthValue) {
						throw new JsonParsingException(
								"Deserializing Rectangle Shapes, width must be a number value, got: " + widthValue,
								parser.getLocation());
					}
					width = parser.getBigDecimal().doubleValue();
				}
				break;
			default:
				// ignore, continue
			}
		}

		if (height == null) {
			throw new JsonParsingException(
					"Deserializing Rectangle Shapes, data object must contain number value \"height\".",
					parser.getLocation());
		}
		if (width == null) {
			throw new JsonParsingException(
					"Deserializing Rectangle Shapes, data object must contain number value \"width\".",
					parser.getLocation());
		}

		return new Rectangle(height, width);
	}

	private Circle deserializeCircle(JsonParser parser, DeserializationContext ctx, Type rtType) {
		Double radius = null;
		boolean radiusEnded = false;
		while (parser.hasNext() && !radiusEnded) {
			Event next = parser.next();
			switch (next) {
			case END_OBJECT:
				radiusEnded = true;
				break;
			case START_OBJECT:
				parser.skipObject();
				break;
			case START_ARRAY:
				parser.skipArray();
				break;
			case KEY_NAME:
				String key = parser.getString();
				if ("radius".equals(key)) {
					Event radiusValue = parser.next();
					if (Event.VALUE_NUMBER != radiusValue) {
						throw new JsonParsingException(
								"Deserializing Circle Shapes, radius must be a number value, got: " + radiusValue,
								parser.getLocation());
					}
					radius = parser.getBigDecimal().doubleValue();
				}
				break;
			default:
				// ignore, continue
			}
		}

		if (radius == null) {
			throw new JsonParsingException(
					"Deserializing Circle Shapes, data object must contain number value \"radius\".",
					parser.getLocation());
		}

		return new Circle(radius);
	}
}
