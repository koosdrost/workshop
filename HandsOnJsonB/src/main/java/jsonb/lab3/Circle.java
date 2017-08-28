package jsonb.lab3;

public class Circle implements Shape {

	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return String.format("Circle[radius=%s]", radius);
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double getSurface() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
}
