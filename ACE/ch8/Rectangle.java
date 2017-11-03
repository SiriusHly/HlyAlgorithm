package ch8;

public class Rectangle implements Shape {
private double length ,width;
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	public Rectangle(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return length*width;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*(length*width);
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

}
