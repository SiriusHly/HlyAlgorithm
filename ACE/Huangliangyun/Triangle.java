package Huangliangyun;

public class Triangle extends Shape {
double a,b,c;
static double p,s;
	public Triangle(double a,double b,double c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}

	@Override
	public double getArea() {
		p=(a+b+c)/2;
		s=Math.sqrt(p*(p-a)*(p-b)*(p-c));
		return s ;
	}

	@Override
	public double getPerimeter() {
		return a+b+c;
	}

}
