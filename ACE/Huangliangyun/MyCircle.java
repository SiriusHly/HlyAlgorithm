package Huangliangyun;

public class MyCircle extends Shape {
double r;
	public MyCircle(double r) {
		this.r = r;
	}

	@Override
	public double getArea() {
		return Math.PI*r*r;
	}

	@Override
	public double getPerimeter() {
		
		return 2*Math.PI*r;
	}

}
