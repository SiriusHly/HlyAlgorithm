package ��ϰ����;

public class ʵ����Rectangle implements ʵ����Shape {
double width,heigh;

	public ʵ����Rectangle() {
	}

	public ʵ����Rectangle(double width, double heigh) {
		super();
		this.width = width;
		this.heigh = heigh;
	}

	@Override
	public double getArea() {

		return width*heigh;
	}

	@Override
	public void draw() {
		System.out.println("I am a ʵ����Rectangle");
	}

}
