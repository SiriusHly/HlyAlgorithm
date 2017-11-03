package 练习测试;

public class 实验四Triangle extends 实验四Shape {
double a,b,c;

	public 实验四Triangle(double a, double b, double c) {
	
	this.a = a;
	this.b = b;
	this.c = c;
}

	public 实验四Triangle() {
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
