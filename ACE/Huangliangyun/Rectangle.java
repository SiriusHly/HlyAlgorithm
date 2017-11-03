package Huangliangyun;

public class Rectangle extends Shape {
double length,width;
	public Rectangle(double length,double width) {
		this.length=length;
		this.width=width;
	}

	@Override
	public double getArea() {
		
		return length*width;
	}

	@Override
	public double getPerimeter() {
		
		return length*2+width*2;
	}

}
