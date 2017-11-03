package Fuxi4;

public class Circle extends Shape {
double r;
	public Circle() {
	}
	public Circle(double r) {
		this.r=r;
	}

	@Override
	public double getArea() {
		return Math.PI*r*r;
	}
	public double getPerimeter() {
		return Math.PI*r*2;
	}

}
