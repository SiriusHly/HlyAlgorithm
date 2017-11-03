package ch7;

public class Circle extends Shape {
private double r;
	public Circle() {
		// TODO Auto-generated constructor stub
	}
	public Circle(double r) {
		super();
		this.r = r;
	}
	
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 3.14*getR()*getR();
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*3.14*getR();
	}

}
