package ch9;

public class Rectangle implements Shape {
	private double width,height;
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width*height;
	}

	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("i am a ÊµÑéËÄTriangle");
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
