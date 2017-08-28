package jsonb.lab3;

public class Square implements Shape {

	private double side;

	public Square(double side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return String.format("Square[side=%s]", side);
	}

	public double getSide() {
		return side;
	}

	@Override
	public double getSurface() {
		return side * side;
	}

	@Override
	public double getPerimeter() {
		return 4 * side;
	}
}
