package ��ϰ����;

public class ʵ����Rectangle extends ʵ����Shape {
double width,heigh;
	public ʵ����Rectangle() {
	}

	public ʵ����Rectangle(double width, double heigh) {
		
		this.width = width;
		this.heigh = heigh;
	}


	@Override
	public double getArea() {
		return width*heigh;
	}

	@Override
	public double getPerimeter() {
		return 2*width*heigh;
	}

}
