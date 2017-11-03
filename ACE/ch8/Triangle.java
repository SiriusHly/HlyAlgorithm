package ch8;

public class Triangle implements Shape {
private double a,b,c;
	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArea() {
		double p = (a+b+c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return a+b+c;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public Triangle(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	

}
