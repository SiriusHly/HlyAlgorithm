package ch9;

public class Circle implements Shape {
	private double r;
	public Circle() {
		// TODO Auto-generated constructor stub
	}

	public Circle(double r) {
		super();
		this.r = r;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI*r*r;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("i am a circle");
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	
}
