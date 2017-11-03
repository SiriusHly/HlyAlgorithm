package ch7;

public class Triangle extends Shape {
private double a,b,c;
	public Triangle() {
		// TODO Auto-generated constructor stub
	}
	public Triangle(double a,double b,double c) {
		super();
		this.a=a;
		this.b=b;
		this.c=c;
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
	@Override
	public double getArea() {
		double p = (a+b+c)/2;
		double s =  Math.sqrt(p*(p-a)*(p-b)*(p-c));
		return s;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return a+b+c;
	}

}
