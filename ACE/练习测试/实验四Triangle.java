package ��ϰ����;

public class ʵ����Triangle extends ʵ����Shape {
double a,b,c;

	public ʵ����Triangle(double a, double b, double c) {
	
	this.a = a;
	this.b = b;
	this.c = c;
}

	public ʵ����Triangle() {
	}

	@Override
	public double getArea() {
		double p;
		double s;
		p=(a+b+c)/2;
		s=Math.sqrt(p*(p-a)*(p-b)*(p-c));
		return s;
	}

	@Override
	public double getPerimeter() {
		return a+b+c;
	}

}
